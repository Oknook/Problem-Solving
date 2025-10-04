def solution(board):
    row = len(board)
    col = len(board[0])
    mat = [[2 for _ in range(col+2)] for _ in range(row+2)]
    for r in range(0, row):
        for c in range(0, col):
            if board[r][c] == 1:
                for i in range(0, 3):
                    mat[r+i][c:c+3] = [1]*3
    return sum(sum(x[1:col+1]) for x in mat[1:row+1]) - row*col