// 
// Decompiled by Procyon v0.5.36
// 

package ElReyLeon;

class defTablero
{
    int posicion;
    int r;
    int c;
    int avance;
    
    public defTablero(final int p, final int r, final int c, final int avance) {
        this.posicion = p;
        this.r = r;
        this.c = c;
        this.avance = avance;
    }
    
    public int getRenglon() {
        return this.r;
    }
    
    public int getColumna() {
        return this.c;
    }
    
    public int getAvance() {
        return this.avance;
    }
}
