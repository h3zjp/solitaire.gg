// Generated rules for Scalataire.
package models.game.rules.generated

import models.game._
import models.game.rules._

/**
 * Original Settings:
 *   Number of cells (C0n): 2
 *   Foundation initial cards (F0d): 0 (None)
 *   Enable stock (Sn): 0 (No stock)
 *   Tableau initial cards (T0d): -3 (Fill rows with rest of deck)
 *   Tableau piles (T0n): 8
 *   Tableau suit match rule for building (T0s): 5 (Regardless of suit)
 *   Number of waste piles (W0n): 0
 *   Similar to (like): streetsandalleys
 *   Related games (related): stronghold, penelopesweb, privatelane
 *   Enable super moves, whatever those are (supermoves): 1
 */
object PrivateLane extends GameRules(
  id = "privatelane",
  title = "Private Lane",
  like = Some("streetsandalleys"),
  related = Seq("stronghold", "penelopesweb", "privatelane"),
  links = Seq(Link("Pretty Good Solitaire", "www.goodsol.com/pgshelp/private_lane.htm")),
  description = "A variation of ^beleagueredcastle^ with two ^freecell^-style cells added.",
  foundations = Seq(
    FoundationRules(
      numPiles = 4,
      wrapFromKingToAce = true,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      numPiles = 8,
      initialCards = InitialCards.RestOfDeck,
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.Any,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = FillEmptyWith.Aces
    )
  ),
  cells = Some(
    CellRules(
      numPiles = 2
    )
  ),
  complete = false
)
