package bai8_clean_code_and_refactoring.thuc_hanh.refactoring_doi_ten_bien_tach_hang;

class Calculator {

    public static int calculate(int  firstOperand, int  secondOperand, char operator) {
        final char ADDITION = '+';
        final char SUBTRACTION  = '-';
        final char MULTIPLICATIPN = '*';
        final char DIVISION = '/';

        switch (operator) {
            case ADDITION:
                return  firstOperand +  secondOperand;
            case SUBTRACTION :
                return  firstOperand -  secondOperand;
            case MULTIPLICATIPN:
                return  firstOperand *  secondOperand;
            case DIVISION:
                if ( secondOperand != 0)
                    return  firstOperand /  secondOperand;

                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
