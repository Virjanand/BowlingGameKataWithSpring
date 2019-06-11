# # Bowling Game Kata
Rules of the game:
- 10 turns
- 2 tries per turns
- all ten pins knocked down in 2 turns is a spare -> 10 + score next turn
- all ten pins knocked down in 1 turn is a strike -> 10 + score next turn
- last rol a spare or strike -> 1 or 2 more rolls respectively
- final score is sum of all scores

Program will not:
- check for valid rolls
- check for correct number of rolls
- no scores for intermediate frames

Examples:
- 12345123451234512345 -> score: 60
- XXXXXXXXXXXX -> score: 300
- 9-9-9-9-9-9-9-9-9-9- -> score: 90
- 5/5/5/5/5/5/5/5/5/5/5 -> score: 150

*ToDo*
- [x] Create test for HelloWorld bean to understand how to use beans and test them
- [ ] -------------------- -> score: 0
- [ ] 11111111111111111111 -> score: 20
- [ ] 1-1-1-1-1-1-1-1-1-1- -> score: 10
- [ ] XXXXXXXXXXXX -> score: 300