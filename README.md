# # Bowling Game Kata
Rules of the game:
- 10 turns
- 2 tries per turns
- all ten pins knocked down in 2 turns is a spare -> 10 + score next turn
- all ten pins knocked down in 1 turn is a strike -> 10 + score next 2 turns
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
- [x] -------------------- -> score: 0
- [x] 1------------------- -> score: 1
- [x] refactor duplication ---... between test and implementation
- [x] 11111111111111111111 -> score: 20
- [x] refactor lambda to method reference
- [ ] ~~1-1-1-1-1-1-1-1-1-1- -> score: 10~~
- [x] refactor: don't use sum, but reduce
- [x] 12345--------------- -> score: 15
- [x] refactor: put filter in method
- [x] X5------------------ -> score: 20
- [ ] ~~refactor: split sumScores in filter part that deals with strike and summation.~~
- [x] refactor: extract maxScore 10
- [x] refactor: extract '0' constant
- [x] rewrite to use charArray, because with stream it's not possible to look to next item
- [x] inline tempScore
- [ ] replace methods with methods for charArray
- [ ] refactor: instead of isNonZero method, use a convertToIntScore method
- [ ] refactor: make sumscore dependent on only current char and check next char if it exists
- [ ] XXXXXXXXXXXX -> score: 300