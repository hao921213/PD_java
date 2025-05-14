import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Hw4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int variable_count = input.nextInt();
		ArrayList<ArrayList<Double>> variable = new ArrayList<>();
		int count = 0;
		//先創立共要幾行式子
		for (int i = 0; i < variable_count; i++) {
			variable.add(new ArrayList<>());
		}
		//輸入
		loop1: for (int i = 0; i < variable_count; i++) {
			count++;
			for (int j = 0; j < variable_count + 1; j++) {
				Double num = input.nextDouble();
				if (num == -999) {
					count--;
					break loop1;
				}
				variable.get(i).add(j, num); // 使用 add(index, element) 方法
			}
		}

		// 如果該行的元素數不足，則補0
		for (int i = count; i < variable_count; i++) {
			for (int j = 0; j < variable_count + 1; j++) {
				variable.get(i).add(0.0);
			}
		}
		
		
		// 高斯消去及判斷解的情況
		boolean notonly=false;
		double factor=0; 
		for (int i = 0; i < variable_count; i++) {
			if (variable.get(i).get(i) == 0) {
				// 如果主對角線上的元素為0，則需要交換
				int rowToSwap = findNonZeroRow(variable, i);
				if (rowToSwap != -1) {
					// 交換行 i 和行 rowToSwap
					Collections.swap(variable, i, rowToSwap);
				} else {
					// 在這裡處理無法找到非零元素的情況
					int temp=1;
					if(i==0) {
						for (int j = i + temp; j < variable.size(); j++) {
							// 交換完後正常處理
							factor = variable.get(j).get(i+temp) / variable.get(i).get(i+temp);
							// factor要消去的倍數
							for (int k = i+temp; k < variable_count + 1; k++) {
								double newValue = variable.get(j).get(k) - factor * variable.get(i).get(k);
								if (k == i+temp && newValue != 0) {
									newValue = 0;
									factor *= -1;
								}
								variable.get(j).set(k, newValue);
								// 儲存消去完的數
							}
						}
					}
					notonly=true;
					continue;
				}
			}
			for (int j = i + 1; j < variable.size(); j++) {
				// 交換完後正常處理
				factor = variable.get(j).get(i) / variable.get(i).get(i);
				// factor要消去的倍數
				for (int k = i; k < variable_count + 1; k++) {
					double newValue = variable.get(j).get(k) - factor * variable.get(i).get(k);
					if (k == i && newValue != 0) {
						newValue = 0;
						factor *= -1;
					}
					variable.get(j).set(k, newValue);
					// 儲存消去完的數
				}
			}
		}
		
		// 判斷解的情況
		if (noSolution(variable, variable_count) == -1) {
		    System.out.println("No solution");
		} else {
		    if (notonly) {
		        System.out.println("Infinite solutions");
		    } else {
		        boolean allZeroDiagonal = true;
		        for (int i = 0; i < variable_count; i++) {
		            if (variable.get(i).get(i) != 0) {
		                allZeroDiagonal = false;
		                break;
		            }
		        }
		        if (allZeroDiagonal) {
		            System.out.println("Infinite solutions");
		        } else {
		            System.out.println("The only solution");
		        }
		    }
		}
	}
	public static int findNonZeroRow(ArrayList<ArrayList<Double>> variable, int columnIndex) {
		for (int i = columnIndex + 1; i < variable.size(); i++) {
			if (variable.get(i).get(columnIndex) != 0) {
				return i;
			}
		}
		return -1; // 如果找不到非零元素的行，返回-1
	}

	public static int noSolution(ArrayList<ArrayList<Double>> variable, int variable_count) {
	    for (int i = 0; i < variable.size(); i++) {
	        boolean allZero = true;
	        for (int j = 0; j < variable_count; j++) {
	            if (variable.get(i).get(j) != 0) {
	                allZero = false;
	                break;
	            }
	        }
	        if (allZero && variable.get(i).get(variable_count) != 0) {
	            return -1; // 發現一個所有變數係數都為零，但結果不為零的方程式
	        }
	    }
	    return 0; // 所有方程式都不符合上述條件，因此系統有解
	}
}
