/* This solution belongs to ackoroa
* I have copied the file as is here for refrence for C++ string Manipulation
* for reading input as I am unaware of the technique, for the original file
* please follow the link:
* https://github.com/ackoroa/UVa-Solutions/blob/master/UVa%20514%20-%20Rails/src/UVa%20514%20-%20Rails.cpp
*/

#include <iostream>
#include <stack>
using namespace std;

int main() {
	int n, target[1000];
	int i;

	while (true) {
		cin >> n;
		if (n == 0)
			break;

		while (true) {
			cin >> target[0];
			if (target[0] == 0){
				cout << endl;
				break;
			}
			for (i = 1; i < n; i++) {
				cin >> target[i];
			}

			int currCoach = 1, targetIndex = 0;
			stack<int> station;
			while(currCoach<=n){
				station.push(currCoach);

				while(!station.empty() && station.top() == target[targetIndex]){
					station.pop();
					targetIndex++;
					if(targetIndex>=n) break;
				}

				currCoach++;
			}

			if(station.empty()) cout << "Yes" << endl;
			else cout << "No" << endl;
		}
	}

	return 0;
}
