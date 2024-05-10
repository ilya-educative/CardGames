module DurakGameAPI {
    requires StandardCardBB;        // Card type
    requires DurakCardInteractionBB;// to define whether card can defend against attacking card
    requires BlindCardCollectionBB; // game deck
    requires BoardCardMapBB;        // game board
    // todo: ('round', 'players-turn-order')
}