#include <iostream>
#include <queue>
#include <tuple>
using namespace std;

int dx[] = { 0,1,0,-1,0,0 };
int dy[] = { 0,0,1,0,-1,0 };
int dz[] = { 1,0,0,0,0,-1 };

bool visit[101][101][101];
int tomato[101][101][101];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(NULL); cout.tie(NULL);
	int M, N, H;
	queue<tuple<int, int, int>> Q;
	cin >> M >> N >> H;
	for (int h = 0; h < H; h++) {
		for (int n = 0; n < N; n++)
			for (int m = 0; m < M; m++) {
				cin >> tomato[h][n][m];
				visit[h][n][m] = false;
				if (tomato[h][n][m] == 1) {
					Q.push(make_tuple(h, n, m));
					visit[h][n][m] = true;
				}
			}
	}
	int day = 0;
	while (!Q.empty()) {
		int size = Q.size();
		for (int s = 0; s < size; s++) {
			auto cur = Q.front(); Q.pop();
			for (int i = 0; i < 6; i++) {
				int nz = get<0>(cur)+dz[i];
				int nx = get<1>(cur)+dx[i];
				int ny = get<2>(cur)+dy[i];

				if (nz >= 0 && nx >= 0 && ny >= 0 && nz < H && nx < N && ny < M
					&& !visit[nz][nx][ny] && tomato[nz][nx][ny] == 0) {
					visit[nz][nx][ny] = true;
					tomato[nz][nx][ny] = 1;
					Q.push(make_tuple(nz, nx, ny));
				}
			}
		}
		day++;
	}
	for (int h = 0; h < H; h++) {
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (tomato[h][n][m] == 0) {
					cout << -1;
					return 0;
				}
			}
		}
	}
    cout<<day-1;
	return 0;
}