package com.example.alex.catsales.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 14.03.17.
 */

public class FakeCatArray extends Activity {
    private final String DRAWABLE = "drawable";
    Context context;
    public FakeCatArray(Context context){
        this.context = context;
        createPhoto();
        createName();
        createBred();
        createDescription();
        createLatitude();
        createLongtude();
        createTelefon();
    }

    private ArrayList<Integer> photo;
    private ArrayList<String> name;
    private ArrayList<String> breed;
    private ArrayList<String> description;
    private ArrayList<Double> latitude;
    private ArrayList<Double> longtude;
    private ArrayList<String> telefon;

    public ArrayList<Integer> getPhoto(){
        return photo;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public ArrayList<String> getBreed() {
        return breed;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public ArrayList<Double> getLatitude() {
        return latitude;
    }

    public ArrayList<Double> getLongtude() {
        return longtude;
    }

    public ArrayList<String> getTelefon() {
        return telefon;
    }

    private void createPhoto(){
        photo = new ArrayList<>();
        ArrayList<String> breedName = new ArrayList<>();
        breedName.add("abissin");
        breedName.add("bombey");
        breedName.add("devon_rex");
        breedName.add("york");
        breedName.add("korat");
        for (String item:breedName
             ) {
            photo.add(context.getResources().getIdentifier(item,
                    DRAWABLE, context.getPackageName()));
        }
    }

    private void createName(){
        name = new ArrayList<>();
        name.add("Васька");
        name.add("Манька");
        name.add("Барсик");
        name.add("Черныш");
        name.add("Леопольд");
    }

    private void createBred(){
        breed = new ArrayList<>();
        breed.add("Абиссинская");
        breed.add("Бомбейская");
        breed.add("Девон рекс");
        breed.add("Йорк");
        breed.add("Корат");
    }

    private void createDescription(){
        description = new ArrayList<>();
        description.add("Абисси́нская кошка — одна из самых древних пород кошек. Изображение кошек на древних египетских росписях (гробница вельможи Небамона 15-14 вв. до н. э., \"Книга мертвых\"), а так же указание их цвета в описаниях \"солнечный кот\", \"лазуритовая кошка горизонта\" наводят на мысли о том, что речь шла именно об абиссинских кошках. Поразительное сходство сохранившихся большеухих скульптур кошек с длинными лапами и вытянутым туловищем почти не оставляет в этом никаких сомнений. На расписях акцент сделан так же на хвост, приобретающий к кончику темный однотонный цвет. Древнеегипетская богиня веселья и пляски Баст (или Бастет) по описаниям имеет характер абиссинской кошки - подвижной, игривой и веселой.");
        description.add("Бомбейская кошка, несмотря на экзотическое название, никакого отношения к Индии не имеет. Она была выведена в 50-е годы ХХ столетия американскими любителями в штате Кентукки, с целью создания миниатюрной кошачьей копии чёрной пантеры. Для этой цели были скрещены бурые кошки бурманской породы с чёрными кошками породы «Американская короткошёрстная». Выведение «чистой» породы длилось 4 поколения кошек, пока не был достигнут положительный результат: была выведена «маленькая пантера». Её шерсть была чёрной и блестящей, плотной и гладкой, как сатин. Голова круглая и, как это есть и у настоящих больших хищников, пропорциональна по отношению ко всему телу. Эта новая порода была официально зарегистрирована в 1958 году. От первой вязки до признания породы прошли долгих 23 года кропотливого труда. В этом же году он был признан настоящим котом мечты.");
        description.add("Первые девон-рексы были найдены в 1960 году в графстве Девоншир (Англия) около заброшенного оловянного рудника в выводке диких котят. Первоначально считалось, что порода имеет родство с корниш-рексами, но эта гипотеза была опровергнута с помощью экспериментального спаривания. Первым зарегистрированным девоном был кот чёрного цвета по кличке Кирли (англ. Kirlee), именно от него ведут свои родословные все коты этой породы. Девон-рексы обычно очень активны, игривы, стремятся к тесному контакту с человеком. Их поведение в шутку описывается как нечто среднее между кошкой, собакой и обезьяной («обезьянка в костюме кошки»). Способны запрыгнуть на значительную высоту; нередко стараются занять минимально вмещающий их уголок, например, на полках или между предметами. Девон-рексы стремятся залезть повыше и способны пройти долгий путь, чтобы залезть на самый верх жилища.\n" +
                "Большинство девон-рексов посвящают своё время какому-либо одному человеку, с кем они чаще всего будут играть. Активно играют в любом возрасте. Кошки этой породы обладают чертами, обычно присущими собакам: их можно научить выполнять трюки, приносить предметы.\n" +
                "Характерная особенность поведения — девон-рексы любят залезать человеку на плечи, сидеть на шее, быть поближе к лицу хозяина.");
        description.add("Данная порода была выведена в 1983 году в Нью-Йорке в Соединённых Штатах Америки американкой Джанет Чифари. Примечательно то, что Джанет не была селекционером, и новая порода у неё получилась случайно.\n" +
                "Среди котят её длинношёрстной кошки появился котенок (кошка) с шоколадным окрасом. Позже у этой шоколадной кошки появились свои котята, среди которых оказался снова один шоколадный, но уже кот. Затем Джанет свела их, и постепенно вывела новую породу.\n" +
                "Достоверно неизвестно, в результате скрещивания каких пород кошек появилась данная порода, есть мнение, что в скрещивании принимали участие сиамские и персидские кошки и коты. Эта порода очень слабо распространена, в основном популярностью они пользуются только у себя на родине.");
        description.add("Кора́т — порода домашней кошки. Размерами и окрасом напоминает русскую голубую кошку, но мех кошек породы Корат скорее одинарный, чем двойной. У их глаз — не изумрудно-зелёный, а оливково-зелёный цвет. Для кошек данной породы одновременно характерны требовательный и настойчивый характер и большие выразительные глаза, придающие морде невинное выражение. Впрочем, зелёными глаза становятся только на 2-4-м годах жизни.\n" +
                "В редких случаях у кошек этой породы отмечаются нервно-мышечные нарушения. В Европе и Америке на самом деле ценятся только те представители породы Корат, которых вывезли из одноимённой провинции Таиланда. Но отличить их от голубых короткошёрстных бурманских или голубовато-серебристых восточных короткошёрстных смогут только специалисты.");
    }

    private void createLatitude(){
        latitude = new ArrayList<>();
        latitude.add(38.9971921);
        latitude.add(38.9171925);
        latitude.add(38.9471927);
        latitude.add(38.9771926);
        latitude.add(38.9371929);
    }

    private void createLongtude(){
        longtude = new ArrayList<>();
        longtude.add(-77.0068700);
        longtude.add(-77.0768705);
        longtude.add(-77.0368703);
        longtude.add(-77.0968709);
        longtude.add(-77.0168706);
    }

    private void createTelefon(){
        telefon = new ArrayList<>();
        telefon.add("000000000");
        telefon.add("000000000");
        telefon.add("000000000");
        telefon.add("000000000");
        telefon.add("000000000");
    }
}