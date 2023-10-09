package backtracking;

import java.util.HashSet;
import java.util.Set;

class Pair{
    Integer row;
    Integer cols;
    public Pair(Integer row,Integer cols)
    {
        this.row=row;
        this.cols=cols;
    }
}

  // This is the robot's control interface.
  // You should not implement it, or speculate about its implementation
  interface Robot1 {
      // Returns true if the cell in front is open and robot moves into the cell.
      // Returns false if the cell in front is blocked and robot stays in the current cell.
      public boolean move();

      // Robot will stay in the same cell after calling turnLeft/turnRight.
      // Each turn will be 90 degrees.
      public void turnLeft();
      public void turnRight();

      // Clean the current cell.
      public void clean();
  }

public class Robot {

      int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
      Set<Pair> visited=new HashSet<>();
      Robot1 robot;

      public void goBack()
      {
          robot.turnRight();
          robot.turnRight();
          robot.move();
          robot.turnRight();
          robot.turnRight();
      }

    public void cleanRoom(Robot1 robot)
    {
      this.robot=robot;
      backtrack(0,0,0);
    }

    public void backtrack(int row,int cols,int d)
    {
        visited.add(new Pair(row,cols));
        robot.clean();
        // going d-->clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for(int i=0;i<4;i++)
        {
            int newD=(d+i)%4;
            int newRow=row+directions[newD][0];
            int newColumn=cols+directions[newD][1];
            if(!visited.contains(new Pair(newRow,newColumn)) && robot.move())
            {
                 backtrack(newRow,newColumn,newD);
                 goBack();
            }
            robot.turnRight();
        }

    }

    public static void main(String[] args) {
         Robot robot=new Robot();
         Robot1 robot1=new Robot1() {
             @Override
             public boolean move() {
                 return false;
             }

             @Override
             public void turnLeft() {

             }

             @Override
             public void turnRight() {

             }

             @Override
             public void clean() {

             }
         };
         robot.cleanRoom(robot1);
    }
}
