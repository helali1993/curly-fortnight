#include <cstdlib>
#include <cstdio>
#include <cstring>

using namespace std;

int a , b, TC, line = 0;
int row[8];

void backtrack(int col);
bool place(int x, int y);

int main() {
	scanf("%d", &TC);
	while(TC--) {
		scanf("%d %d", &a, &b); a--; b--;
		line = 0;
		memset(row, 0, sizeof row);
		printf("SOLN       COLUMN\n");
		printf(" #      1 2 3 4 5 6 7 8\n\n");
		backtrack(0);
		if(TC) {
			printf("\n");
		}
	}
	return 0;
	  
}

void backtrack(int col){
	if(col == 8 && row[b] == a) {
		printf("%2d      %d", ++line, row[0] + 1);
		for(int i = 1; i < 8; i++) {
			printf(" %d", row[i] + 1);
		}
		printf("\n");
	}
	for(int i = 0; i < 8; i++) {
		if(place(i, col)) {
			row[col] = i;
			backtrack(col + 1);
		}
	}
}

bool place(int to_row, int in_col){
	for(int i = 0; i < in_col; i++){
		if(row[i] == to_row) {
			return false;
		}
		if(abs(to_row - row[i]) == abs(i - in_col)) {
			return false;
		}
	}
	return true;
}
