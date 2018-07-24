public class gobang {

    int chessBoard[][]=new int[15][15];
    int score[][]=new int[15][15];

    //init
    public void init(int array[][]){

        for(int i=0;i<15;i++)
            for(int j=0;j<15;j++)
                array[i][j]=0;
    }

    //输出
    public void print(int array[][]){

        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                System.out.print(array[i][j]+"  ");
            }
            System.out.println("\n");
        }

    }





}
