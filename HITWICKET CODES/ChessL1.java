import java.util.*;

class ChessL1{

    public static ArrayList<ArrayList<String>> grid =  new ArrayList<ArrayList<String>>();
    public static Map<String,ArrayList<Integer>> pawnPosP1 = new HashMap<String,ArrayList<Integer>>();
    public static Map<String,ArrayList<Integer>> pawnPosP2 = new HashMap<String,ArrayList<Integer>>();

    static void initializeGrid(){
        for(int i=0;i<5;i++){
            grid.add(new ArrayList<String>());
            for(int j=0;j<5;j++){
                grid.get(i).add("_");
            }
        }
    }
    static void printGrid(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(" " + grid.get(i).get(j));
            }
            System.out.println();
        }
    }
    static void setInitialRow(int row){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter initial pawn position in comma seprated fashion ");
        //input format: P1,P3,P4,P5,P2 (First character capital followed by a number followed by comma)
        String s = sc.nextLine();   
        String[] elem = s.split(",");
        for(int i=0;i<elem.length;i++){
            if(row == 4)
                grid.get(row).set(i, "A-" + elem[i]);
            else
                grid.get(row).set(i, "B-" + elem[i]);
            
        }
        printGrid();
    }

    static void setInitialPawnVertPos(int row){
        for(int i=0;i<5;i++){
            if(row == 4){
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(row);
                a.add(i);
                pawnPosP1.put(grid.get(row).get(i), a);
            }else{
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(row);
                a.add(i);
                pawnPosP2.put(grid.get(row).get(i), a);
            }
            
        }
    }
    static void movePawn(String pawn,int x,int y,String command,int player){
        if(player == 1){
            if(command.equals("F")){
                if(x>0 && grid.get(x-1).get(y).contains("A") == false){
                    grid.get(x-1).set(y, grid.get(x).get(y));
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    a.add(x-1);
                    a.add(y);
                    pawnPosP1.put(pawn, a);
                    grid.get(x).set(y, "_");
                }else{
                    System.out.println("Cant move forward or invalid move");
                }
            }else if(command .equals("B")){
                if(x>0 && grid.get(x+1).get(y).contains("A") == false){
                    grid.get(x+1).set(y, grid.get(x).get(y));
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    a.add(x+1);
                    a.add(y);
                    pawnPosP1.put(pawn, a);
                    grid.get(x).set(y, "_");
                }else{
                    System.out.println("Cant move backward");
                }
            }else if(command.equals("L")){
                if(y>0 && grid.get(x).get(y-1).contains("A") == false){
                    grid.get(x).set(y-1, grid.get(x).get(y));
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    a.add(x);
                    a.add(y-1);
                    pawnPosP1.put(pawn, a);
                    grid.get(x).set(y, "_");
                }else{
                    System.out.println("Cant move Left");
                }
            }else if(command.equals("R")){
                if(y<4 && grid.get(x).get(y+1).contains("A") == false){
                    grid.get(x).set(y+1, grid.get(x).get(y));
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    a.add(x);
                    a.add(y+1);
                    pawnPosP1.put(pawn, a);
                    grid.get(x).set(y, "_");
                }else{
                    System.out.println("Cant move Right");
                }
            }
        }else{  
            if(command.equals("F")){
                if(x<4 && grid.get(x+1).get(y).contains("B") == false){
                    grid.get(x+1).set(y, grid.get(x).get(y));
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    a.add(x+1);
                    a.add(y);
                    pawnPosP2.put(pawn, a);
                    grid.get(x).set(y, "_");
                }else{
                    System.out.println("Cant move forward or invalid move");
                }
            }else if(command .equals("B")){
                if(x>0 && grid.get(x-1).get(y).contains("B") == false){
                    grid.get(x-1).set(y, grid.get(x).get(y));
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    a.add(x-1);
                    a.add(y);
                    pawnPosP2.put(pawn, a);
                    grid.get(x).set(y, "_");
                }else{
                    System.out.println("Cant move backward");
                }
            }else if(command.equals("R")){
                if(y>0 && grid.get(x).get(y-1).contains("B") == false){
                    grid.get(x).set(y-1, grid.get(x).get(y));
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    a.add(x);
                    a.add(y-1);
                    pawnPosP2.put(pawn, a);
                    grid.get(x).set(y, "_");
                }else{
                    System.out.println("Cant move Right");
                }
            }else if(command.equals("L")){
                if(y<4 && grid.get(x).get(y+1).contains("B") == false){
                    grid.get(x).set(y+1, grid.get(x).get(y));
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    a.add(x);
                    a.add(y+1);
                    pawnPosP2.put(pawn, a);
                    grid.get(x).set(y, "_");
                }else{
                    System.out.println("Cant move Left");
                }
            }
        }

        printGrid();
    }
    public static void main(String[] args) {
        int chance = 1;
        initializeGrid();
        Scanner sc = new Scanner(System.in);
        int p1Row = 4;
        int p2Row = 0;
        while (true){
            if(chance %2 == 1){
                if(chance == 1){
                   setInitialRow(p1Row);
                   setInitialPawnVertPos(p1Row);
                   chance ++; 
                }
                else{
                    System.out.println("Enter Move: ");
                    String s = sc.nextLine();
                    String[] elem = s.split(":");
                    ArrayList<Integer> pos = pawnPosP1.get("A-" + elem[0]);
                    if(elem[0].contains("P") == false && elem[0].contains("H") == false){
                        System.out.println("Invalid Input");
                    }else{
                    movePawn("A-" + elem[0],pos.get(0), pos.get(1), elem[1],1);
                    chance += 1;
                    }
                }
            }else{
                if (chance == 2){
                    setInitialRow(p2Row);
                    setInitialPawnVertPos(p2Row);
                    chance ++;
                }else{
                    System.out.println("Enter Move: ");
                    String s = sc.nextLine();
                    String[] elem = s.split(":");
                    if(elem[0].contains("P") == false && elem[0].contains("H") == false){
                        System.out.println("Invalid Input");
                    }else{
                        ArrayList<Integer> pos = pawnPosP2.get("B-" + elem[0]);
                        movePawn("B-" + elem[0],pos.get(0), pos.get(1), elem[1],2);
                        chance+=1;
                    }
                    
                }
            }
        }
    }
}