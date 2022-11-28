public class Laplace {
    //Determinante realizdo pelo método de Laplace
    static void Cofator(double[][] matriz, double[][] temporaria, int x, int y, int z) {
        int i = 0;
        int j = 0;
        for (int linha = 0; linha < z; linha++) {
            for (int coluna = 0; coluna < z; coluna++) {
                if (linha != x && coluna != y) {
                    temporaria[i][j++] = matriz[linha][coluna];
                    if (j == z - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    static double detDaMatriz(double[][] matriz, int z) {
        double detLaplace = 0.0;
        if (z == 1) {
            return matriz[0][0];
        }
        double temporaria[][] = new double[z][z];
        double Multiplicador = 1;
        for (int f = 0; f < matriz.length; f++) {
            Cofator(matriz, temporaria, 0, f, z);
            detLaplace += Multiplicador * matriz[0][f] * detDaMatriz(temporaria, z - 1);
            Multiplicador = -Multiplicador;
        }
        return detLaplace;
    }
}