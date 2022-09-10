# HITWICKET-2022-VIT-SUBMISSION

## Result
Fully working codes are developed in the given time frame for all the 3 levels.

## Language
Java

## Structure of code
A static variable grid and 2 static maps are created.

### Variable `grid`: 
Contains the 5X5 grid with empty positions as `_` and filled position as mentioned in question paper,
grid is updated on every move made by any player.

### Variable `Map<String,ArrayList<Integer>> charPosP1 and charPos2` :
Contains X and Y coordinate position of each pawn/hero in the game for each player.
Used to reduce searching time to O(1).

### Invalidity checks:

1. If anything apart from P or H is entered in the move, it wont be accepted.
2. No move is executed if the ending position is out of bounds. 
3. We will not go to desitination if our own piece is present.
