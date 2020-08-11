package bai8_clean_code_and_refactoring.bai_tap;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int scoreOfPlayer1, int scoreOfPlayer2) {
        final int ZERO = 0;
        final int FIFTEEN = 1;
        final int THIRTY = 2;
        final int FORTY = 3;
        boolean isEqual = scoreOfPlayer1 == scoreOfPlayer2;

        if (isEqual) {
            switch (scoreOfPlayer1) {
                case ZERO:
                    return "Love-All";
                case FIFTEEN:
                    return "Fifteen-All";
                case THIRTY:
                    return "Thirty-All";
                case FORTY:
                    return "Forty-All";
                default:
                    return "Deuce";
            }
        }

        if (scoreOfPlayer1 >= 4 || scoreOfPlayer2 >= 4) {
            int minusResult = scoreOfPlayer1 - scoreOfPlayer2;
            boolean advantagePlayer1 = minusResult == 1;
            boolean advantagePlayer2 = minusResult == -1;
            boolean player1WWin = minusResult >= 2;

            if (advantagePlayer1) {
                return "Advantage player1";
            } else if (advantagePlayer2) {
                return "Advantage player2";
            } else if (player1WWin) {
                return "Win for player1";
            } else {
                return "Win for player2";
            }
        }
        return player1Name;
    }
}

//    {
//        for (int i = 1; i < 3; i++) {
//            if (i == 1) tempScore = scoreOfPlayer1;
//            else {
//                scoreTennisGame += "-";
//                tempScore = scoreOfPlayer2;
//            }
//            switch (tempScore) {
//                case 0:
//                    scoreTennisGame += "Love";
//                    break;
//                case 1:
//                    scoreTennisGame += "Fifteen";
//                    break;
//                case 2:
//                    scoreTennisGame += "Thirty";
//                    break;
//                case 3:
//                    scoreTennisGame += "Forty";
//                    break;
//            }
//        }
//    }
//        return scoreTennisGame;
//}
//}