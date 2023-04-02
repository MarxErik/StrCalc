package MainTwo;

import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine())
        {
            try {
                Input input = new Input(scan.nextLine());
                //input.text();
                System.out.println("\""+ input.operation()+"\"");
            } catch (Exception e) {
                System.out.println("throws Exception");
                break;
            }
        }
    }
}
class  Input
{
    private String strOne;
    private String znak;
    private String strTwo;
    private String output;
    private void setStrOne(String strOne) {
        this.strOne = strOne;
    }
    private void setZnak(String znak) {
        this.znak = znak;
    }
    private void setStrTwo(String strTwo) {
        this.strTwo = strTwo;
    }
    private void setOutput(String output) {
        this.output = output;
    }


    public String getStrOne() {
        return strOne;
    }

    public String getZnak() {
        return znak;
    }

    public String getStrTwo() {
        return strTwo;
    }

    public String getOutput() {
        return output;
    }
    Input (String strOZT) throws Exception
    {
        String [] strM1  = strOZT.split("\"");
        String [] strM2 = new String[2];
        int posleVtorieKovichkiVStrOZT = strOZT.indexOf("\"", 1);

        if (strM1[2].trim().indexOf("*")!=-1)
            {
                setZnak("*");
                strM2 = strOZT.split("(?<=[^|]{" + (posleVtorieKovichkiVStrOZT - 1) + "})\\*",2);
            }
        else if (strM1[2].trim().indexOf("/")!=-1)
            {
                setZnak("/");
                strM2 = strOZT.split("(?<=[^|]{" + (posleVtorieKovichkiVStrOZT - 1) + "})\\/",2);
            }

        switch (strM1[2].trim())
            {
                case "+": setZnak("+");
                    strM2 = strOZT.split("(?<=[^|]{" + (posleVtorieKovichkiVStrOZT - 1) + "})\\+",2);
                    break;
                case "-": setZnak("-");
                    strM2 = strOZT.split("(?<=[^|]{" + (posleVtorieKovichkiVStrOZT - 1) + "})\\-",2);
                    break;
            }


        if(strM2[0].trim().indexOf("\"") == 0 && strM2[0].trim().lastIndexOf("\"") == strM2[0].trim().length() - 1 &&
                strM2[0].trim().indexOf("\"") == 0 && strM2[1].trim().lastIndexOf("\"") == strM2[1].trim().length() - 1 && (znak=="+" || znak=="-"))
            {
                setStrOne(strM2[0].trim().substring(1,strM2[0].trim().lastIndexOf("\"")));
                setStrTwo(strM2[1].trim().substring(1,strM2[1].trim().lastIndexOf("\"")));

                if (strOne.length()>10 || strOne.length() <1 || strTwo.length()>10 || strTwo.length()<1)
                    {
                        throw new Exception();
                    }
            }
        else if(strM2[0].trim().indexOf("\"") == 0 && strM2[0].trim().lastIndexOf("\"") == strM2[0].trim().length() - 1 &&
                Integer.parseInt(strM2[1].trim())<=10 && Integer.parseInt(strM2[1].trim())>=1 && (znak=="*" || znak=="/"))
            {
                setStrOne(strM2[0].trim().substring(1,strM2[0].trim().lastIndexOf("\"")));
                setStrTwo(strM2[1].trim());

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


    String operation()
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