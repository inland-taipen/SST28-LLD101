public class Demo01 {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        parseFromRaw parser = new parseFromRaw();
        Printer printer = new Printer();
        FakeDb fakeDb = new FakeDb();
      validation validation = new validation();

        OnboardingService svc = new OnboardingService(parser,printer,validation,fakeDb);

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(fakeDb));
    }
}
