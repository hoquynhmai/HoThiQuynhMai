package bai8_clean_code_and_refactoring.bai_tap;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int scoreOfPlayer1, int scoreOfPlayer2) {
        String scoreTennisGame = "";
        int tempScore = 0;
        if (scoreOfPlayer1 == scoreOfPlayer2)
        {
            switch (scoreOfPlayer1)
            {
                case 0:
                    scoreTennisGame = "Love-All";
                    break;
                case 1:
                    scoreTennisGame = "Fifteen-All";
                    break;
                case 2:
                    scoreTennisGame = "Thirty-All";
                    break;
                case 3:
                    scoreTennisGame = "Forty-All";
                    break;
                default:
                    scoreTennisGame = "Deuce";
                    break;
            }
        }
        else if (scoreOfPlayer1 >= 4 || scoreOfPlayer2 >= 4)
        {
            int minusResult = scoreOfPlayer1 - scoreOfPlayer2;
            if (minusResult == 1) scoreTennisGame ="Advantage player1";
            else if (minusResult == -1) scoreTennisGame ="Advantage player2";
            else if (minusResult >= 2) scoreTennisGame = "Win for player1";
            else scoreTennisGame = "Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = scoreOfPlayer1;
                else { scoreTennisGame += "-"; tempScore = scoreOfPlayer2;}
                switch(tempScore)
                {
                    case 0:
                        scoreTennisGame += "Love";
                        break;
                    case 1:
                        scoreTennisGame += "Fifteen";
                        break;
                    case 2:
                        scoreTennisGame += "Thirty";
                        break;
                    case 3:
                        scoreTennisGame += "Forty";
                        break;
                }
            }
        }
        return scoreTennisGame;
    }
}