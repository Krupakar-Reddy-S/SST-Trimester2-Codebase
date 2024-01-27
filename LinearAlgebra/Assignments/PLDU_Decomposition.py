def pldu(M):
    n = len(M)
    
    # Initialize matrices
    P = [[0] * n for _ in range(n)]
    L = [[0] * n for _ in range(n)]
    D = [[0] * n for _ in range(n)]
    U = [[0] * n for _ in range(n)]

    # Initialize permutation matrix P as the identity matrix
    for i in range(n):
        P[i][i] = 1

    # Perform PLDU decomposition
    for k in range(n):
        # Find pivot (maximum absolute value) in the column below the diagonal
        pivot_row = max(range(k, n), key=lambda i: abs(M[i][k]))

        # Swap rows in permutation matrix P
        P[k], P[pivot_row] = P[pivot_row], P[k]

        # Swap rows in matrix M
        M[k], M[pivot_row] = M[pivot_row], M[k]

        # Decompose the matrix into L, D, and U
        L[k][k] = 1
        D[k][k] = M[k][k]

        for i in range(k + 1, n):
            L[i][k] = M[i][k] / D[k][k]
            D[i][i] = M[i][i] - sum(L[i][j] * D[j][j] * U[j][i] for j in range(k))
            
        for i in range(k, n):
            U[k][i] = M[k][i] / D[k][k]

    return P, L, D, U

# Example
M = [
    [2, -1, 0],
    [-1, 2, -1],
    [0, -1, 2]
]   

P, L, D, U = pldu(M)

print("P:")
for row in P:
    print(row)

print("\nL:")
for row in L:
    print(row)

print("\nD:")
for row in D:
    print(row)

print("\nU:")
for row in U:
    print(row)
