package com.ntsakonas;

import java.util.Scanner;

/**
 * M0NSTER CHASE PROGRAM (ported from the original listing
 * Stimulating Simulations, 2nd Edition, by C.W.Engel (c) 1979
 * pg24-26
 * <p>
 * This is a direct port to Java, maintaining the variable names and the same flow.
 * No changes and no refactorings ( other than a few synthetic instructions to simulate BASIC peculiarities)
 */

/*
 * Original listing in Atari BASIC
 *  Variables:
 *  - R,C Your row and column
 *  - X,Y Monster's row and column
 *  - L,M Temporary variables
 *  - M$ Your move (N,E,S,W,O)
 *  - D Direction of the monster (1-8)
 *  - T Turns (1-10)
 *
 *  5 REM SET CONDITIONS
 *  10 X=1: Y=1
 *  20 R=5: C=5
 *  30 FOR T=1 TO 10
 *  35 REM DISPLAY GRID
 *  40 FOR I=1 TO 5
 *  50 FOR J=1 TO 5
 *  60 PRINT TAB(8)
 *  70 IF I=X AND J=Y THEN PRINT "M";: GO TO 100
 *  80 IF I=R AND J=C THEN PRINT "Y";: GO TO 100
 *  90 PRINT ".";
 *  100 NEXT J
 *  110 PRINT
 *  120 NEXT I
 *
 *  210 ?:?:? "MOVE NUMBER"; T
 *  220 INPUT "DIRECTION (NESWO)"; M$
 *  240 IF M$="N" THEN R=R-1
 *  250 IF M$="E" THEN C=C+1
 *  260 IF M$="S" THEN R=R+1
 *  270 IF M$="W' THEN C=C-1
 *
 *  280 IF R*C=0 OR R>5 OR C>5 THEN PRINT "OUT OF BOUNDS": GO TO 520
 *  290 IF R=X AND Y=C THEN PRINT "EATEN": GO TO 520
 *  300 IF X=R AND Y<C THEN D=1
 *  310 IF X>R AND Y<C THEN D=2
 *  320 IF X>R AND Y=C THEN D=3
 *  330 IF X>R AND Y>C THEN D=4
 *  340 IF X=R AND Y>C THEN D=5
 *  350 IF X<R AND Y>C THEN D=6
 *  360 IF X<R AND Y=C THEN D=7
 *  370 IF X<R AND Y<C THEN D=8
 *  380 D=D+INT(3*RND(1)-1)
 *  390 IF D=0 THEN D=8
 *  400 IF D=9 THEN D=1
 *  410 IF D>1 AND D<5 THEN X=X-1
 *  420 IF D>5 THEN X=X+1
 *  430 IF D>3 AND D<7 THEN Y=Y-1
 *  440 IF D<3 OR D=8 THEN Y=Y+1
 *  450 IF X=O THEN X=X+1
 *  460 IF Y=O THEN Y=Y+1
 *  470 IF X=6 THEN X=X-1
 *  480 IF Y=6 THEN Y=Y-1
 *  490 IF X=R AND Y=C THEN PRINT "EATEN": GO TO 520
 *  500 NEXT T
 *  510 PRINT "YOU SURVIVED!"
 *  520 INPUT "PLAY AGAIN"; Y$
 *  530 IF Y$="Y" THEN RUN
 *  540 END
 */
public class MonsterChaseOriginal {
    public static void main(String[] args) throws Exception {

        // simulating system input
        Scanner INPUT = new Scanner(System.in);

        // the original program can "run" it self from start
        // the closest we can go is to have the program in a do/while loop
        char Y$;
        do {
            int R, C;
            int X, Y;
            char M$;
            int D = 0;
            int T;


            // REM SET CONDITIONS
            X = 1;
            Y = 1;
            R = 5;
            C = 5;

            for (T = 1; T <= 10; T++) {
                for (int I = 1; I <= 5; I++) {
                    for (int J = 1; J <= 5; J++) {
                        System.out.print("\t\t");
                        if (I == X && J == Y) System.out.print("M");
                        else if (I == R && J == C) System.out.print("Y");
                        else System.out.print(".");
                    }
                    System.out.println();
                }

                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("MOVE NUMBER " + T);
                System.out.print("DIRECTION (NESWO) ");
                M$ = INPUT.nextLine().charAt(0);

                if (M$ == 'N') R = R - 1;
                if (M$ == 'E') C = C + 1;
                if (M$ == 'S') R = R + 1;
                if (M$ == 'W') C = C - 1;

                if (R * C == 0 || R > 5 || C > 5) {
                    System.out.println("OUT OF BOUNDS");
                    break;
                }
                if (R == X && Y == C) {
                    System.out.println("EATEN");
                    break;
                }
                if (X == R && Y < C) D = 1;
                if (X > R && Y < C) D = 2;
                if (X > R && Y == C) D = 3;
                if (X > R && Y > C) D = 4;
                if (X == R && Y > C) D = 5;
                if (X < R && Y > C) D = 6;
                if (X < R && Y == C) D = 7;
                if (X < R && Y < C) D = 8;

                D = D + (int) (Math.random() * 3.0 - 1.0);
                if (D == 0) D = 8;
                if (D == 9) D = 1;
                if (D > 1 && D < 5) X = X - 1;
                if (D > 5) X = X + 1;
                if (D > 3 && D < 7) Y = Y - 1;
                if (D < 3 || D == 8) Y = Y + 1;
                if (X == 0) X = X + 1;
                if (Y == 0) Y = Y + 1;
                if (X == 6) X = X - 1;
                if (Y == 6) Y = Y - 1;
                if (X == R && Y == C) {
                    System.out.println("EATEN");
                    break;
                }

            }
            // this is an added check as we do no have GOTO's
            // this is line 510 modified
            if (T > 10)
                System.out.println("YOU SURVIVED!");
            System.out.print("PLAY AGAIN ");
            Y$ = INPUT.nextLine().charAt(0);
        } while (Y$ == 'Y');

    }

}
