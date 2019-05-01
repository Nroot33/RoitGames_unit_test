import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;


public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp(){
        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스","탑");
        Champion jungleChamp = new Champion("리신","정글");
        Champion midChamp = new Champion("르블랑","미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }
    @Test
    public void emptycheck(){
        List<String> emptyList = new ArrayList<String>();
        assertThat(emptyList,empty());
    }
    @Test
    public void Notnullcheck(){
        String lck = "LCK";
        assertThat(lck,notNullValue());
    }
    @Test
    public void stringcheck(){
        String sampleString = "Player Focus";
        String startString = "Player";
        String endString = "Focus";
        assertThat(sampleString,anyOf(startsWith(startString),containsString(endString)));
        assertThat(sampleString,is(endsWith(endString)));
    }
    @Test
    public void floatpointcheck(){
        assertThat(3.14,closeTo(3,0.2)); // 오차범위내 값 성공
    }
    @Test
    public void championlistcheck(){
        assertThat(championList.get(2),anything()); //random 값과 같이 그냥 값을 잘 가져오면 성공
    }
    @Test
    public void championlist_sizecheck(){
        assertThat(championList.size(),is(5));
        assertThat(championList, Matchers.<Champion>hasSize(5));
    }
    @Test
    public void championlist_Champcheck(){
        Champion supporter = new Champion("Taric","bottom")
        assertThat("Taric",is(supporter.getName()));
        assertThat("Taric",is(equalTo(supporter.getName())));
        assertThat("Taric",equalTo(supporter.getName()));
    }
    @Test
    public void championlist_Champ_position_check(){
        assertThat(championList.get(0),Matchers.<Champion>hasProperty("position"));
        assertThat(championList.get(0),Matchers.<Champion>hasProperty("position",equalTo("탑")));
        //오류 assertThat(championList.get(0),Matchers.<Champion>hasProperty("position",equalTo("정글")));
    }
    @Test
    public void championlist_Champ_samename_check(){
        List<String > championNames = Arrays.asList("루시안","애쉬","트리스타나","바루스","카이사");
        assertThat(championNames.get(0), Matchers.<String>hasToString("루시안"));
    }
    @Test
    public void sholdTopChampionIsDarius(){
        Optional<Champion> filterdChampion = championList.stream()
                .filter(c->c.getPosition().equals("탑"))
                .findFirst();
        String champName = filterdChampion.get().getName();
        assertTrue(champName.equals("다리우스"));
        assertThat("다리우스",is(champName));
    }

}