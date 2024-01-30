# import numpy as np
# from pandas import DataFrame as pdData
# import math

# SIZE_MATRIX_X = 1
# SIZE_MATRIX_Y = 6

# def generate_tabinitial(A, b, c):
#     [m, n] = A.shape
#     if m != b.size:
#         print()
#         exit(1)
#     if n != c.size:
#         print()
#         exit(1)
    
#     result = np.column_stack((A, b))
#     result = np.append(result, np.column_stack((c, 0)), axis=0)
#     return range(n, n + m), result

# def generate_tabinitial_withID(A, b, c):
#     m, n                = A.shape
#     rng, tabinitial     = generate_tabinitial(A, b, c)
#     identity            = np.vstack((np.identity(m), np.zeros(m)))
#     return rng, np.concatenate((tabinitial, identity), axis=1)

# def positive(v):
#     return all(v >= 0), np.amin(v), np.where(v == np.amin(v))


# def init(tab, A):
#     m, n    = A.shape

#     opt         = -tab[m, n]
#     tab_b       = tab[:m, n]
#     tab_c       = np.concatenate((tab[m , 0:n]
#          ,tab[m , n + 1:]))

#     tab_A       = np.hstack((tab[0:m ,0:n ]
#         ,tab[ 0:m , n + 1 :]))

#     return opt, tab_b, tab_c, tab_A

# def index_smallest_pos(v):
#     return np.where(v > 0, v, np.inf).argmin()

# def rapportmin(a, b, m):
#     out = []
#     for i in range(0, m-1):
#         if b[i] != 0:
#             out.append(a[i] / b[i])
            
#     return index_smallest_pos(np.array(out))

# def resolution(tab, A, c):
#     opt, tab_b, tab_c, tab_A    = init(tab, A)
#     m, n                        = tab.shape
#     sign, minimum, index_min    = positive(tab_c)
    
#     if (index_min[0] > c.size).all():
#         index_min = list(index_min)
#         index_min[0] += 1
#         index_min = tuple(index_min)
    
#     tab = tab.astype(np.float32)

#     if sign:
#         return tab_b, opt
#     else:
#         if all(tab[:,index_min] <= 0):
#             print()
#             exit(1)
#         else:
#             A_s                 = tab[:A.shape[0],index_min]

#             index_pivot         = rapportmin(tab_b, A_s, m)

#             ligne_pivot         = tab[index_pivot]
#             colonne_pivot       = tab[:,index_min]

#             pivot               = tab[index_pivot,index_min]
            
#             tab[index_pivot]    = ligne_pivot / float(pivot)
            
#             for i in range(0, len(tab)):
#                 if not np.array_equal(tab[i], tab[index_pivot]):
#                     tab[i] = tab[i] - tab[index_pivot] * tab[i, index_min]

#             print("\n",pdData(tab))

#             return resolution(tab, A, c)


# if __name__ == '__main__':

#     c = [[1, 1]]
    
#     A = [[1, -1], [3, 1], [4, 3]]
#     b = [2, 5, 7]

#     (c, A, b)   = map(lambda t: np.array(t), [c, A, b])
    
#     range_tab1, tab_initail1    = generate_tabinitial_withID(A, b, c)

#     data_frame1                 = pdData(tab_initail1)

#     print()
#     print(data_frame1)

#     x, y                        = resolution(tab_initail1, A, c)
    
#     print('Optimal Solution', abs(y))
#     print('X', x,)


import numpy as np
from scipy.linalg import lu

def pldu(M):
    """M: a non-singular matrix
        returns: (P, L, D, U) such that M = PLDU
        where
            P is a row permutation matrix,
            L is a unit lower triangular matrix, 
            D is a diagonal matrix, 
            U is an unit upper triangular matrix"""

    P, L, U = lu(M)
    n = M.shape[0]
    D = np.diag(np.diag(U))
    U = np.triu(U, k=1) + np.eye(n)
    
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


# def pldu(M):
#     """M: a non-singular matrix
#         returns: (P, L, D, U) such that M = PLDU
#         where
#             P is a row permutation matrix,
#             L is a unit lower triangular matrix, 
#             D is a diagonal matrix, 
#             U is an unit upper triangular matrix"""
    
#     n = len(M)
#     P = np.eye(n)
#     L = np.eye(n)
#     U = M.copy()
#     D = np.zeros((n, n))

#     for j in range(n-1):
#         maxindex = abs(U[j:, j]).argmax() + j
#         if maxindex != j:
#             # Swap rows in U
#             U[[j, maxindex]] = U[[maxindex, j]]
#             # Swap rows in P
#             P[[j, maxindex]] = P[[maxindex, j]]
#             if j >= 1:
#                 temp = L[j, :j].copy()
#                 L[j, :j] = L[maxindex, :j]
#                 L[maxindex, :j] = temp
#         for i in range(j+1, n):
#             L[i, j] = U[i, j] / U[j, j]
#             U[i, j:] = U[i, j:] - L[i, j] * U[j, j:]
    
#     for i in range(n):
#         D[i, i] = U[i, i]
#         U[i, i] = 1
#         for j in range(i+1, n):
#             U[i, j] = U[i, j] / D[i, i]

#     print("P:")
#     for row in P:
#         print(row)

#     print("\nL:")
#     for row in L:
#         print(row)
    
#     print("\nD:")
#     for row in D:
#         print(row)
    
#     print("\nU:")
#     for row in U:
#         print(row)

if __name__ == '__main__':
    M = np.array([
        [2, -1, 0],
        [-1, 2, -1],
        [0, -1, 2]
    ])

    pldu(M)