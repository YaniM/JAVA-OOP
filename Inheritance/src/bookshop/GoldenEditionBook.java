package bookshop;

public class GoldenEditionBook extends Book {
    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public double getPrice(){
        double price = 0;

        return price=super.getPrice()+super.getPrice()*0.3;
    }
}
