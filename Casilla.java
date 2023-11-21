public class Casilla {
    private final int posx;
    private final int posy;
    private int valor;
    private final boolean mina;
    private boolean descubierta;
    public Casilla(int x, int y, double dificultad){
        this.posx = x;
        this.posy = y;
        this.mina = Math.random() < dificultad;
        this.descubierta = false;
        this.valor = 0;
    }

    public int getPosx() {return posx;}
    public int getPosy() {return posy;}
    public boolean getMina(){return mina;}
    public boolean getDescubierta(){return descubierta;}
    public void setValor(int valor) {this.valor = valor;}
    public boolean descubrir(){
        boolean explosion = false;
        this.descubierta = true;
        if (mina){
            explosion = true;
        }
        return !explosion;
    }
    public int valorar(Casilla[][] campo){
        int cantidad = 0;
        try{
            if (campo[this.getPosy()-1][this.getPosx()-1].getMina()){
                cantidad++;
            }
        } catch (IndexOutOfBoundsException e){}
        try{
            if (campo[this.getPosy()-1][this.getPosx()].getMina()){
                cantidad++;
            }
        } catch (IndexOutOfBoundsException e){}
        try{
            if (campo[this.getPosy()-1][this.getPosx()+1].getMina()){
                cantidad++;
            }
        } catch (IndexOutOfBoundsException e){}
        try{
            if (campo[this.getPosy()][this.getPosx()-1].getMina()){
                cantidad++;
            }
        } catch (IndexOutOfBoundsException e){}
        try{
            if (campo[this.getPosy()][this.getPosx()+1].getMina()){
                cantidad++;
            }
        } catch (IndexOutOfBoundsException e){}
        try{
            if (campo[this.getPosy()+1][this.getPosx()-1].getMina()){
                cantidad++;
            }
        } catch (IndexOutOfBoundsException e){}
        try{
            if (campo[this.getPosy()+1][this.getPosx()].getMina()){
                cantidad++;
            }
        } catch (IndexOutOfBoundsException e){}
        try{
            if (campo[this.getPosy()+1][this.getPosx()+1].getMina()){
                cantidad++;
            }
        } catch (IndexOutOfBoundsException e){}
        return cantidad;
    }
    @Override
    public String toString() {
        String resul = " ";
        if(this.descubierta && !this.getMina()){
            resul = Integer.toString(this.valor);
        }
        else if(this.descubierta && this.getMina()){
            resul = "*";
        }
        return  resul;
    }
}