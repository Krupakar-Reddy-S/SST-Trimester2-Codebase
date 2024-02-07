import numpy as np

def pldu(M):
    """M: a non-singular matrix
        returns: (P, L, D, U) such that M = PLDU
        where
            P is a row permutation matrix,
            L is a unit lower triangular matrix, 
            D is a diagonal matrix, 
            U is an unit upper triangular matrix"""

    n = M.shape[0]
    P = np.eye(n)
    L = np.eye(n)
    U = np.triu(M.astype(float), k=1) + np.eye(n) # Convert U to float to ensure consistent data type
    D = np.zeros_like(M, dtype=float)  # Use float for D as well

    for i in range(n - 1):
        pivot_index = np.argmax(np.abs(U[i:, i])) + i

        # Swap rows in P
        P[[i, pivot_index], :] = P[[pivot_index, i], :]

        # Swap rows in U and L
        U[[i, pivot_index], :] = U[[pivot_index, i], :]
        L[[i, pivot_index], :] = L[[pivot_index, i], :]

        # Update L and D
        L[i + 1:, i] = U[i + 1:, i] / U[i, i]
        D[i, i] = U[i, i]

        # Update U
        U[i + 1:, i + 1:] -= np.outer(L[i + 1:, i], U[i, i + 1:])

    D[-1, -1] = U[-1, -1]

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

Matrix = np.array([
    [2, -1, 0],
    [-1, 2, -1],
    [0, -1, 2]
])

pldu(Matrix)