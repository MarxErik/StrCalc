import java.util.Arrays;
import java.util.Scanner;

public class MainOne {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine())
        {
            try {
                Str str = new Str(scan.nextLine());
                //str.text();
                System.out.println("\""+ str.calc()+"\"");
            } catch (Exception e) {
                System.out.println("throws Exception");
                break;
            }
        }
    }
}
 class Str
{
    private String strOne;
    private String znak;
    private String strTwo;
    private String output;
    Str(String strOZT) throws Exception {
        int vtorieKivichkiVStr = strOZT.indexOf("\"", 1);

        int plus = strOZT.indexOf("+",vtorieKivichkiVStr);
        int minus = strOZT.indexOf("-",vtorieKivichkiVStr);
        int multiply = strOZT.indexOf("*",vtorieKivichkiVStr);
        int divide = strOZT.indexOf("/",vtorieKivichkiVStr);
        String strM [] = new String[2];


        String strMM [] = strOZT.split("\"");
        //System.out.println(String.join("|", strMM));
        //System.out.println(strMM[2]);

        if ( plus != -1 )
            {
                this.znak = "+";
                strM = strOZT.split("(?<=[^|]{" + (vtorieKivichkiVStr - 1) + "})\\+",2);
            }
        else if ( minus != -1 )
            {
                System.out.println("и в минус зашел");
                this.znak = "-";
                strM = strOZT.split("(?<=[^|]{" + (vtorieKivichkiVStr - 1) + "})\\-",2);
            }
        else if ( multiply != -1 )
            {
                this.znak = "*";
                strM = strOZT.split("(?<=[^|]{" + (vtorieKivichkiVStr - 1) + "})\\*",2);
            }
        else if ( divide != -1 )
            {
                this.znak = "/";
                strM = strOZT.split("(?<=[^|]{" + (vtorieKivichkiVStr - 1) + "})\\/",2);
            }
        //вернемя

        int strOneZero = strM[0].trim().indexOf("\"");
        int strOneLast = strM[0].trim().lastIndexOf("\"");
        int strTwoZero = strM[1].trim().indexOf("\"");
        int strTwoLast = strM[1].trim().lastIndexOf("\"");
        if(strOneZero == 0 && strOneLast == strM[0].trim().length() - 1 && strTwoZero == 0 && strTwoLast == strM[1].trim().length() - 1 && (plus!=-1 || minus!=-1))
            {
                strOne = strM[0].trim().substring(1,strOneLast);
                strTwo = strM[1].trim().substring(1,strTwoLast);
                if (strOne.length()>10 || strOne.length() <1 || strTwo.length()>10 || strTwo.length()<1)
                    {
                        throw new Exception();
                    }
            }
        else if(strOneZero == 0 && strOneLast == strM[0].trim().length() - 1 && Integer.parseInt(strM[1].trim())<=10 && Integer.parseInt(strM[1].trim())>=1 && (multiply!=-1 || divide!=-1))
            {
                strOne = strM[0].trim().substring(1,strOneLast);
                strTwo = strM[1];
                if (strOne.length()>10 || strOne.length() <1 )
                    {
                        throw new Exception();
                    }
            }
        else
            {
                throw new Exception();
            }


    }



    String calc()
        {
            switch (this.znak)
                {
                case "+":
                        output= strOne + strTwo;
                    break;
                case "-":
                        if (strOne.equals(strTwo))
                            {
                                output="";
                            }
                        else if(strOne.indexOf(strTwo)!=-1)
                            {
                                String [] strOneMinusStrTwo = strOne.split(strTwo);
                                output = String.join("",strOneMinusStrTwo);
                            }
                        else
                            {
                                output = strOne;
                            }
                    break;
                case "*":
                        output = strOne;
                            for (int i = 2; i <= Integer.parseInt(strTwo.trim()); ++i)
                                {
                                    output = output + strOne;
                                }
                            if (output.length() > 40)
                                {
                                    output=output.substring(0,40)+"...";
                                }
                    break;
                case "/":
                    int x =  strOne.length() / Integer.parseInt(strTwo.trim());
                    output = strOne.substring(0,x);
                    break;
                }
            return output;
        }
    void text ()
    {
        System.out.println("первая строка "+ strOne);
        System.out.println("знак "+znak);
        System.out.println("вторая строка "+ strTwo);
    }

}

