package services.sandbox

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import services.history.GameHistoryService
import services.leaderboard.GameSeedService
import services.user.UserStatisticsService
import utils.ApplicationContext

import scala.concurrent.Future

object BackfillGames extends SandboxTask {
  override def id = "backfill-games"
  override def description = "Register all games in the seeds and statistics engines."
  override def run(ctx: ApplicationContext) = {
    GameHistoryService.getAll.flatMap { games =>
      val filteredGames = games.filter(g => g.isCompleted && !g.isLogged)
      val gamesFuture = filteredGames.foldLeft(Future.successful(Unit)) { (f, g) =>
        f.flatMap { unused =>
          val completed = g.completed.getOrElse(throw new IllegalStateException())
          if (g.isWin) {
            GameSeedService.registerWin(g.rules, g.seed, g.player, g.moves, g.duration.toInt, completed)
          } else {
            GameSeedService.registerLoss(g.rules, g.seed)
          }
          UserStatisticsService.registerGame(g)
        }
      }

      gamesFuture.map { unused =>
        s"Ok: [${filteredGames.length}] games loaded."
      }
    }
  }
}