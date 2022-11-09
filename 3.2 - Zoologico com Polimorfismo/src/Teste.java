public class Teste{
    public static void main(String[] args) throws Exception {
        System.out.println("Passo 2:");
        Animal animal = new Lobo("Jacob", "cinza");
        System.out.println(animal.getNome());
        animal = new Galinha("Olivia", false);
        System.out.println(animal.getNome());
        System.out.println("Passo 3:");
        animal = new Lobo("Jacob", "cinza");
        System.out.println(animal.getDescricaoLonga());
        animal = new Galinha("Olivia", false);
        System.out.println(animal.getDescricaoLonga());
    }
}