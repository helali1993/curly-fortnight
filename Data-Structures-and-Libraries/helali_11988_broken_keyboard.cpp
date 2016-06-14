#include <stdio.h>
#include <stdlib.h>
#include <list>
using namespace std;

int main() {
	
	list<char> ll;
	
	char temp;
	char* str;
	str = (char *) malloc(100000);
	char* str_ptr;
	bool home = false, end = true;
	int pos = 0;
	list<char>::iterator it;
	
	while(scanf("%s", str) != EOF){
		
		for(str_ptr = str; *str_ptr != '\0'; str_ptr++ ) {
			if(*str_ptr == '[') {
				home = true;
				end = false;
				pos = 0;
				continue;
			}
			if(*str_ptr == ']') {
				end = true;
				home = false;
				continue;
			}
			
			if(end) {
				ll.push_back(*str_ptr);
			}
			if(home) {
				it = ll.begin();
				advance(it, pos);
				ll.insert(it, *str_ptr);
				pos++;
			}
		}
		
		for(it = ll.begin(); it != ll.end(); ++it) {
			printf("%c", *it);
		}
		printf("\n");
		pos = 0;
		home = false;
		end = true;
		ll.clear();
	}
	return 0;
}
