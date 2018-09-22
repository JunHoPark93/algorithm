#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	vector< pair<int, string> > v;
	v.push_back(pair<int, string>(10, "Mike"));
	v.push_back(pair<int, string>(100, "Bob"));
	v.push_back(pair<int, string>(30, "John"));
	v.push_back(pair<int, string>(50, "Susan"));
	v.push_back(pair<int, string>(33, "Lee"));
	
	sort(v.begin(), v.end());
	for(int i=0 ; i<v.size(); i++) {
		cout << v[i].second << ' ';
	}
}
