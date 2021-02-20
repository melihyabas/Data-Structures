import java.nio.file.*;

/***
 * This is the second driver class and it solves the part2's problem.
 */
public class Driver
{
    /***
     * Main method of part2 tests all methods of classes
     * @param args Command Line Argument
     */
    public static void main(String args[])
    {
        try
        {

            int i,k,s=0;

            String data = new String();
            data = new String(Files.readAllBytes(Paths.get("text.txt")));
            char[] a = data.toCharArray();

            MyStack stc = new MyStack();

            for(i=0 ; i<a.length ; i++)
            {
                System.out.printf("%c",a[i]);
            }

            String result = new String();
            result = "";

            i=0;
            MyArrayList vr = new MyArrayList();
            String tmp = new String();
            tmp = "";
            while (a[i]!='(')
            {
                if(a[i]=='=')
                {
                    vr.addVar(a[i - 1]);
                    while (a[i+1]!='\n')
                    {
                        tmp += a[i+1];
                        i++;
                    }
                    vr.addVal(tmp);
                    tmp = "";
                }
                i++;
            }

            double[] hlp = new double[vr.sizeVal];
            int j,e=0;

            for(j=0 ; j<vr.sizeVal ; j++)
            {
                hlp[j] = Double.parseDouble(vr.getVal(j));
            }

            String[] helper = new String[hlp.length];
            for(j=0 ; j<helper.length ; j++)
            {
                helper[j] = Double.toString(hlp[j]);
            }


            while(i<a.length)
            {

                if(i+1<a.length-1&&(a[i]<48 || a[i]>57)&&a[i]!='('&&a[i]!=')'&&a[i]!=' '&&a[i]!='+'&&a[i]!='-'&&a[i]!='*'&&a[i]!='/'&&a[i+1]==' ')
                {

                    j=0;
                    while (j<vr.sizeVal)
                    {
                        if(a[i]==vr.getVar(j))
                        {
                            //       for(int q=0 )
                            result += helper[j];
                            result += ' ';
                        }
                        j++;
                    }
                }
                if((a[i]=='o'||a[i]=='i'||a[i]=='b'||a[i]=='*'||a[i]=='+'||a[i]=='-'||a[i]=='/'))
                {
                    if(i+1<a.length-1 && (a[i+1]<48 || a[i+1]>57))
                        stc.push(a[i]);
                }

                if ((int) (a[i]) >= 48 && (int) (a[i]) <= 57) {
                    result += a[i];
                    if (i + 1 < a.length - 1 && a[i + 1] == ' ')
                        result += ' ';
                }

                if(a[i] == '.')
                    result += a[i];
                if(i+1<a.length-1 && a[i] == '-' && a[i+1]!=' ')
                    result += a[i];

                if (a[i] == '(' )
                {
                    if(i>=2)
                    {
                        if(a[i-2]!='o')
                            stc.push(a[i]);
                    }
                    else
                        stc.push(a[i]);
                }
                if (a[i] == ')')
                {
                    i++;
                    while (!stc.empty() && stc.peek().x != '(' )
                    {
                        if(stc.peek().x == 'o') {
                            result += "cos ";
                            stc.pop();
                        }
                        else if(stc.peek().x == 'i') {
                            result += "sin ";
                            stc.pop();
                        }
                        else if(stc.peek().x == 'b') {
                            result += "abs ";
                            stc.pop();
                        }
                        else {
                            result += stc.pop().x;
                            result += ' ';
                        }
                    }
                    if(!stc.empty())
                        stc.pop();
                }

                i++;

            }
            while (!stc.empty())
            {
                result += stc.pop().x;
                result += ' ';
            }


            System.out.printf("\n\nPostfix:  %s\n",result);
            char[] res;
            res = result.toCharArray();

            double num1,num2, fnl;
            String temp = new String();
            temp = "7.54";

            num1 = Double.parseDouble(temp);
            temp = "";

            int oprt = 0;
            MyStack2 stc3 = new MyStack2();

            for(i=0 ; i<res.length ; i++)
            {
                if ((i+1<res.length-1 && res[i]=='-' && res[i+1]!=' ')||((int) (res[i]) >= 48 && (int) (res[i]) <= 57))
                {
                    while (res[i]!=' ')
                    {
                        temp += res[i];
                        i++;
                    }

                    num1 = Double.parseDouble(temp);

                    temp = "";
                    stc3.push(num1);

                }
                if((i+1<res.length-1 && res[i]=='-' && a[i+1]!=' '))
                    System.out.printf("\n");

                if(res[i]=='*'||res[i]=='+'||res[i]=='-'||res[i]=='/')
                {
                    oprt++;

                    num2 = stc3.pop().x;
                    num1 = stc3.pop().x;

                    if(res[i] == '+')
                    {
                        fnl = num1 + num2;

                        stc3.push(fnl);
                    }
                    if(res[i] == '-')
                    {
                        fnl = num1 - num2;

                        stc3.push(fnl);
                    }
                    if(res[i] == '*')
                    {
                        fnl = num1 * num2;

                        stc3.push(fnl);
                    }
                    if(res[i] == '/')
                    {
                        fnl = num1 / num2;
                        stc3.push(fnl);
                    }
                }
                else if(res[i]=='i'||res[i]=='o'||res[i]=='b')
                {
                    num1 = stc3.pop().x;
                    if(res[i]=='i')
                    {
                        stc3.push(StaticMethods.sinus(num1));
                    }
                    if(res[i]=='o')
                    {
                        stc3.push(StaticMethods.cosinus(num1));

                    }
                    if(res[i]=='b')
                    {
                        stc3.push(StaticMethods.abs(num1));
                    }
                }
            }

            System.out.printf("\nResult: %s\n",stc3.pop().x);


        }
        catch (Exception e)
        {
            System.out.printf("-%s-",e);
        }
    }
}