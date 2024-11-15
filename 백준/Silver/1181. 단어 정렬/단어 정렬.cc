#include <iostream>
#include <string>
#include <cmath>
#include <algorithm>
#include <vector>
#include <tuple>

using namespace std;

bool sorting(string str, string str2)
{
    if (str.length() == str2.length()) return (str < str2);
    else return (str.length() < str2.length());
}

int main()
{
    vector<string> sv;
    int n;
    cin >> n;
    string tmp;
    for (int i = 0; i < n; i++)
    {
        cin >> tmp;
        if (find(sv.begin(), sv.end(), tmp) == sv.end())
        {
            sv.push_back(tmp);
        }
    }
    sort(sv.begin(), sv.end(), sorting);

    for (int i = 0; i < sv.size(); i++)
    {
        cout << sv[i] << "\n";
    }

    return 0;
}