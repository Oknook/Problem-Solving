#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<vector<int>> v(2, vector<int>(41, 0));
    v[0][0] = 1;
    v[1][1] = 1;
    for (int i = 2; i < 41; i++)
    {
        for (int j = 0; j < 2; j++)
        {
            v[j][i] = v[j][i-1]+v[j][i-2];
        }
    }

    int t;
    cin >> t;
    for (int i = 0; i < t; i++)
    {
        int n;
        cin >> n;
        cout << v[0][n] << " " << v[1][n] << "\n";
    }
    

    return 0;
}