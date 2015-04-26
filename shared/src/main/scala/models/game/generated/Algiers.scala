// Generated 2015-04-26 for Scalataire.
package models.game.generated

import models.game._
import models.game.rules._

object Algiers extends GameRules(
  id = "algiers",
  title = "Algiers",
  description = "A three-deck variation of ^carthage^.",
  deckOptions = DeckOptions(
    numDecks = 3
  ),
  stock = Some(
    StockRules(
      dealTo = StockDealTo.TableauFirstSet,
      maximumDeals = Some(1),
      cardsDealt = StockCardsDealt.Count(2)
    )
  ),
  foundations = Seq(
    FoundationRules(
      numPiles = 12,
      wrapFromKingToAce = true,
      canMoveFrom = FoundationCanMoveFrom.Never,
      autoMoveCards = true
    )
  ),
  tableaus = Seq(
    TableauRules(
      name = "Reserve",
      numPiles = 9,
      initialCards = InitialCards.Count(6),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.None,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = TableauFillEmptyWith.Aces,
      maxCards = 1
    ),
    TableauRules(
      numPiles = 12,
      initialCards = InitialCards.Count(1),
      cardsFaceDown = TableauFaceDownCards.Count(0),
      suitMatchRuleForBuilding = SuitMatchRule.SameSuit,
      suitMatchRuleForMovingStacks = SuitMatchRule.None,
      emptyFilledWith = TableauFillEmptyWith.Aces
    )
  ),
  complete = false
)
