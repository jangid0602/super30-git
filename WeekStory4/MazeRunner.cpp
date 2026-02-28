#include<iostream>
#include<vector>
using namespace std;

class MazeRunner {
    public:
    vector<vector<int>> inputGrid() {
        int n;
        cout << "Enter the number of rows/columns:";
        cin >> n;
        cout << "Enter grid values:";
        vector<vector<int>> grid(n, vector<int>(n, 0));
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                cin >> grid[r][c];
            }
        }
        return grid;
    }

    bool findPath(vector<vector<int>>& grid, int r, int c) {
        int n = grid.size();
        if(r < 0 || r >= n || c < 0 || c >= n) return false;
        if(grid[r][c] == 0) return false;
        if(r == n-1 && c == n-1) return true;
        return findPath(grid, r+1, c) || findPath(grid, r, c+1);
    }

    bool mazeRunner() {
        vector<vector<int>> grid = inputGrid();
        return findPath(grid, 0, 0);
    }
};

int main() {
    MazeRunner *runner = new MazeRunner();
    if(runner->mazeRunner()) cout << "True" << endl;
    else cout << "False" << endl;
    return 0;
}