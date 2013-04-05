import java.util.*;
public class OWUD {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        int cases = 1;
        while (true) {
        
            int n = input.nextInt();
            
            if (n == 0) return;
            
            // input
            Board board = new Board();
            board.size = n;
            board.pegs = new Peg[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                
                    Peg peg = new Peg();
                    peg.pieces = new boolean[n];
                    peg.end = 0;
                    int q = input.nextInt();
                    for (int k = 0; k < q; ++k) {
                        int w = input.nextInt();
                        if (w == 1)
                            peg.pieces[peg.end] = true;
                        else
                            peg.pieces[peg.end] = false;
                        ++peg.end;
                    }
                    board.pegs[i][j] = peg;
                }
            }
            
            int play = input.nextInt();
            boolean player = true;
            if (play == 2)
                player = false;
                
            // solve
            ArrayList<Integer> safe = new ArrayList<Integer>();
            boolean win = false;
            int pos = -1;
            for (int i = 0; i < n && !win; ++i) {
                for (int j = 0; j < n && !win; ++j) {
                    int answer = checkMove(board, i, j, player, true);
                    if (answer == 1) {
                        win = true;
                        pos = i * n + j + 1;
                    }
                    else if (answer == 0) {
                        safe.add(i * n + j + 1);
                    }
                }
            }
            
            // output
            if (win) {
                System.out.print("Board " + cases + ": Winning move at peg " + pos + "\n");
            }
            else if (safe.size() > 0) {
                System.out.print("Board " + cases + ": Safe moves at:");
                for (int i = 0; i < safe.size(); ++i) {
                    System.out.print(" " + safe.get(i));
                }
                System.out.print("\n");
            }
            else {
                System.out.print("Board " + cases + ": No safe moves found!\n");
            }
            ++cases;
        }
    }
    
    public static int checkMove(Board board, int i, int j, boolean player, boolean first) {
    
        // place move
        Peg peg = board.pegs[i][j];
        if (peg.end + 1 > board.size) {
            return -1;
        }
        peg.pieces[peg.end] = player;
        ++peg.end;
        boolean globalwin = false;
        // check peg
        if (peg.end == board.size) {
            boolean win = true;
            for (int k = 0; k < peg.end; ++k) {
                if (peg.pieces[k] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                globalwin = true;
            }
        }
        // check row
        if (!globalwin) {
            boolean win = true;
            for (int k = 0; k < board.size; ++k) {
                if (board.pegs[i][k].end == 0) {
                    win = false;
                    break;
                }
                if (board.pegs[i][k].pieces[board.pegs[i][k].end - 1] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                globalwin = true;
            }
        }
        // check column
        if (!globalwin) {
            boolean win = true;
            for (int k = 0; k < board.size; ++k) {
                if (board.pegs[k][j].end == 0) {
                    win = false;
                    break;
                }
                if (board.pegs[k][j].pieces[board.pegs[k][j].end - 1] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                globalwin = true;
            }
        }
        // check left diag
        if (!globalwin && i == j) {
            boolean win = true;
            for (int k = 0; k < board.size; ++k) {
                if (board.pegs[k][k].end == 0) {
                    win = false;
                    break;
                }
                if (board.pegs[k][k].pieces[board.pegs[k][k].end - 1] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                globalwin = true;
            }
        }
        // check right diag
        if (!globalwin && i + j == board.size - 1) {
            boolean win = true;
            for (int k = 0; k < board.size; ++k) {
                if (board.pegs[k][board.size - 1 - k].end == 0) {
                    win = false;
                    break;
                }
                if (board.pegs[k][board.size - 1 - k].pieces[board.pegs[k][board.size - 1 - k].end - 1] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                globalwin = true;
            }
        }
        if (globalwin) {
            // reset
            --peg.end;
            peg.pieces[peg.end] = false;
            return 1;
        }
        else if (first) {
            // check other move
            int jj = checkMove(board, i, j, !player, !first);
            // reset
            --peg.end;
            peg.pieces[peg.end] = false;
            if (jj == 1)
                return -1;
            else
                return 0;
        }
        else {
            // reset
            --peg.end;
            peg.pieces[peg.end] = false;
            return 0;
        }
    }
    
    private static class Board {
        public int size;
        public Peg[][] pegs;
    }
    
    private static class Peg {
        public boolean[] pieces;
        public int end;
    }
}
