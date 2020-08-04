package com.shiyi.controller;

import com.google.gson.Gson;
import com.shiyi.dao.PoetryDao;
import com.shiyi.service.PoetryService;
import com.shiyi.service.VerseService;
import com.shiyi.utils.UrlLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/poetry")
public class PoetryController {

    @Autowired
    PoetryService poetryService;

    @Autowired
    VerseService verseService;

    @RequestMapping(value = "shows")
    public void getPoetryAll(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(new Gson().toJson(poetryService.findAllPoetry()));
    }

    @RequestMapping("/seek")
    public void getPoetry(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PoetryDao dao = null;
        List<PoetryDao> daos = null;

        String id = request.getParameter(UrlLabel.ID);
        String name = request.getParameter(UrlLabel.NAME);
        String label = request.getParameter(UrlLabel.LABEL);
        String authorId = request.getParameter(UrlLabel.AUTHORID);
        String authorName = request.getParameter(UrlLabel.AUTHORNAME);

        if (id != null){
            dao = poetryService.findByIdPoetry(id);
//            poetryService.savePoetry(dao);
            id = null;
        }else if (name != null){
            daos = poetryService.fingByNamePoetry(name);
            name = null;
        }else if (label != null){
            daos = poetryService.findByLabelPoetry(label);
            label = null;
        }else if (authorId != null){
            daos = poetryService.findByAuthorIdPoetry(authorId);
            authorId = null;
        }else if (authorName != null){
            daos = poetryService.findByAuthorNamePoetry(authorName);
            authorName = null;
        }else {

        }

        if (dao != null){
            System.out.println("返回数据："+dao.toString());
            response.getWriter().println(new Gson().toJson(dao));
        } else if (daos != null){
            System.out.println("返回数据："+daos.toString());
            response.getWriter().println(new Gson().toJson(daos));
        }

    }

    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void savePoetry(@RequestBody PoetryDao poetry, HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
//        System.out.println("post:" + poetry.toString());
        poetryService.savePoetry(poetry);
        response.getWriter().println("true");
    }

//    @RequestMapping(value = "saved")
//    public void saveP(HttpServletResponse response) throws IOException {
//        response.setContentType("text/html;charset=utf-8");
//        PoetryDao poetry = new Gson().fromJson(getPoetryJson(), PoetryDao.class);
//        poetryService.savePoetry(poetry);
//
//        response.getWriter().println("true");
//    }

    private String getPoetryJson(){
        return "{\"appreciations\":[{\"series\":\"02\",\"text\":\"　　这篇文章可分为两部分：前一部分描写莲花高洁的形象；第二部分则揭示了莲花的比喻义，分评三花，并以莲自况，抒发了作者内心深沉的慨叹。\"},{\"series\":\"03\",\"text\":\"　　首句“水陆草木之花，可爱者甚蕃。”选用“可爱”二字，包罗群芳，表明托物寄兴，并不刻意求工，极见其立言斟酌之妙。\"},{\"series\":\"04\",\"text\":\"　　接着叙说“晋陶渊明独爱菊”。陶渊明不肯为五斗米折腰，解绶归隐后，饮酒赋诗，安享“采菊东篱下，悠然见南山”的田园逸趣。“独爱菊”，显示渊明雅致芬芳，傲然物外的性格，而且更加明确了题意：陶渊明可以爱菊抒怀，我怎不可独爱莲呢？\"},{\"series\":\"05\",\"text\":\"　　继写“自李唐来，世人甚爱牡丹”，写了唐人，特别是统治阶层“甚爱牡丹”的好尚，这几句像是重复，但实为加深语意也，而且此句入文，让对比感更为强烈，为其求莲之高洁铺下了引子。大意是周敦颐本人独爱莲与晋陶渊明的爱菊避世不同，为保持一份高洁，宁愿终老南山。他要在尘世中当个出淤泥而不染的君子。这种在污世保持清白与独自避世求真的心态，与众人皆羡富贵的从众心态是有着思想境界上本质的区别的。这为爱莲说所要表达的“出淤泥而不染”作了最好的铺垫。\"}," +
                "{\"series\":\"06\",\"text\":\"　　然后作者撇开一笔说，让那些人爱其所爱吧，“予独爱莲之出淤泥而不染，濯清涟而不妖，中通外直，不蔓不枝，香远益清，亭亭净植，可远观而不可亵玩焉”。这一连串铺叙，对莲花挺拔秀丽的芳姿，清逸超群的美德，特别是可敬而不可侮慢的嵚崎磊落的风范，作了有力的渲染。这几句隐喻作者本身具有“出淤泥而不染，濯清莲而不妖”的高尚品格。实际上，他说的意思就是：官场黑暗，要在官场上保持自己高洁的品格，就如同莲花出淤泥而不染那么难。这也是他为官的经验总结，因为他不想同流合污。而“濯清莲而不妖”，不过是作者的一种良好愿望罢了。他为官正直，数洗冤狱，为民作主；晚年定居庐山，著书明道，洁身自爱，颐养天年，便是身体力行，澹泊明志的体现。这正是这篇小品能给人思想情趣以深切感染的着力之处。\"},{\"series\":\"07\",\"text\":\"　　接下来，作者对三种花象征的不同性格进行了比较和品评：“予谓菊，花之隐逸者也；牡丹，花之富贵者也；莲，花之君子者也。”本来，花是不具备人格的，但在作者眼里，莲花近于菊，却不像菊那样清高冷傲，似乎是逃避现实的隐者；它更不像牡丹那样妍丽妖冶，以富贵媚人。莲花出于污浊现实而不受沾染，受清水洗濯而不显妖冶，实为百花丛中的贤君子。另外，" +
                "莲花又是佛教中的圣物，如来、观音均以莲花为座。唐释道世《三宝敬佛》云：“故十方诸佛，同出于淤泥之浊；三身正觉，俱坐于莲台之上。”作者《题莲》诗也云：“佛爱我亦爱，清香蝶不偷。一般清意味，不上美人头。”与这篇小品参照，情趣相得益彰。\"},{\"series\":\"08\",\"text\":\"　　最后，作者评花进而对“爱”也作出评价：“噫！菊之爱，陶后鲜有闻；莲之爱，同予者何人？牡丹之爱，宜乎众矣！”深深地慨叹：当今之世真隐者少，有德者寡，而趋炎附势钻刺富贵之门的小人比比皆是；这莽莽红尘，能有几个志同道合的人，共同去根治这社会痼疾呢？这里先用花进行比喻，让花的特性喻人，虽平淡，但比喻帖切，然后借花喻人，将陶渊明的避世，世人皆追求荣华富贵的心态描写的淋漓尽致。言下虽不免流露出一种孤掌难鸣的哀怨，但意味深长，无情地鞭挞了那些寡廉鲜耻之徒。这里，周敦颐是高傲的，他那种不从众只求纯净的心态，在碌碌尘世中是难能可贵的。他感叹，是因为世风日下，大多数人皆被世事玷染。\"}],\"author\":{\"dynasty\":\"宋\",\"name\":\"周敦颐\",\"summary\":\"周敦颐（1017年6月1日—1073年7月14日），又名周元皓，原名周敦实，字茂叔，谥号元公，道州营道楼田保（今湖南省道县）人，世称濂溪先生。是北宋五子之一，" +
                "宋朝儒家理学思想的开山鼻祖，文学家、哲学家。著有《周元公集》《爱莲说》《太极图说》《通书》（后人整编进《周元公集》）。周敦颐所提出的无极、太极、阴阳、五行、动静、主静、至诚、无欲、顺化等理学基本概念，为后世的理学家反复讨论和发挥，构成理学范畴体系中的重要内容。► 35篇诗文\"},\"authorName\":\"周敦颐\",\"comments\":[{\"field\":\"　　甚\",\"series\":\"00\",\"text\":\"很，十分。\"},{\"field\":\"说\",\"series\":\"01\",\"text\":\"一种议论文的文体，可以直接说明事物或论述道理，也可以借人、借事或借物的记载来论述道理。\"},{\"field\":\"之\",\"series\":\"02\",\"text\":\"的。\"},{\"field\":\"可爱\",\"series\":\"03\",\"text\":\"值得怜爱。\"},{\"field\":\"者\",\"series\":\"04\",\"text\":\"花。\"},{\"field\":\"甚\",\"series\":\"05\",\"text\":\"很，非常。\"},{\"field\":\"蕃\",\"series\":\"06\",\"text\":\"多。\"},{\"field\":\"自\",\"series\":\"07\",\"text\":\"自从。\"},{\"field\":\"李唐\",\"series\":\"08\",\"text\":\"指唐朝。\"},{\"field\":\"独\",\"series\":\"10\",\"text\":\"只，仅仅。\"},{\"field\"" +
                ":\"之\",\"series\":\"11\",\"text\":\"主谓之间取消句子独立性。\"},{\"field\":\"出\",\"series\":\"12\",\"text\":\"长出。\"},{\"field\":\"淤泥\",\"series\":\"13\",\"text\":\"污泥。\"},{\"field\":\"染\",\"series\":\"14\",\"text\":\"沾染（污秽）。\"},{\"field\":\"濯\",\"series\":\"15\",\"text\":\"洗涤。\"},{\"field\":\"清涟\",\"series\":\"16\",\"text\":\"水清而有微波，这里指清水。\"},{\"field\":\"妖\",\"series\":\"17\",\"text\":\"美丽而不端庄。\"},{\"field\":\"通\",\"series\":\"18\",\"text\":\"贯通；通透。\"},{\"field\":\"直\",\"series\":\"19\",\"text\":\"挺立的样子。\"},{\"field\":\"中通外直\",\"series\":\"20\",\"text\":\"（它的茎）内空外直。\"},{\"field\":\"不蔓不枝\",\"series\":\"21\",\"text\":\"不生蔓，不长枝香远益清。\"},{\"field\":\"益\",\"series\":\"22\",\"text\":\"更加。\"},{\"field\":\"清\",\"series\":\"23\",\"text\":\"清芬。\"},{\"field\":\"亭亭净植\",\"series\":\"24\",\"text\":\"笔直地洁净地立在那里。\"},{\"field\":\"亭亭\",\"series\":\"25\",\"text\":\"耸立的样子。\"}," +
                "{\"field\":\"植\",\"series\":\"26\",\"text\":\"树立。\"},{\"field\":\"可\",\"series\":\"27\",\"text\":\"只能。\"},{\"field\":\"亵玩\",\"series\":\"28\",\"text\":\"玩弄。\"},{\"field\":\"亵\",\"series\":\"29\",\"text\":\"亲近而不庄重。\"},{\"field\":\"焉\",\"series\":\"30\",\"text\":\"句末语气词，这里指当于现代汉语的“啊” “呀”，助词。\"},{\"field\":\"　　谓\",\"series\":\"00\",\"text\":\"认为。\"},{\"field\":\"隐逸者\",\"series\":\"01\",\"text\":\"指隐居的人。\"},{\"field\":\"在封建社会里，有些人不愿意跟统治者同流合污，就隐居避世；君子\",\"series\":\"02\",\"text\":\"指道德品质高尚的人。\"},{\"field\":\"者\",\"series\":\"03\",\"text\":\"……的人或物。\"},{\"field\":\"噫\",\"series\":\"05\",\"text\":\"感叹词，相当于现在的“唉”。\"},{\"field\":\"菊之爱\",\"series\":\"06\",\"text\":\"对于菊花的喜爱。\"},{\"field\":\"之\",\"series\":\"07\",\"text\":\"语气助词，的。\"},{\"field\":\"（一说为“宾语提前的标志”）鲜\",\"series\":\"08\",\"text\":\"少。\"},{\"field\":\"闻\",\"series\":\"09\",\"text\":\"听说。\"}," +
                "{\"field\":\"同予者何人\",\"series\":\"10\",\"text\":\"像我一样的还有什么人呢？宜乎众矣。\"},{\"field\":\"宜乎\",\"series\":\"11\",\"text\":\"当然（应该）。\"},{\"field\":\"宜\",\"series\":\"12\",\"text\":\"当。\"},{\"field\":\"众\",\"series\":\"13\",\"text\":\"众多。\"}],\"dynasty\":\"宋\",\"labels\":[\"初中文言文\",\"莲花\",\"品格\"],\"name\":\"爱莲说\",\"verses\":[{\"classic\":false,\"comments\":[{\"field\":\"　　甚\",\"series\":\"00\",\"text\":\"很，十分。\"},{\"field\":\"说\",\"series\":\"01\",\"text\":\"一种议论文的文体，可以直接说明事物或论述道理，也可以借人、借事或借物的记载来论述道理。\"},{\"field\":\"之\",\"series\":\"02\",\"text\":\"的。\"},{\"field\":\"可爱\",\"series\":\"03\",\"text\":\"\"},{\"field\":\"亵玩\",\"series\":\"28\",\"text\":\"玩弄。\"},{\"field\":\"亵\",\"series\":\"29\",\"text\":\"亲近而不庄重。\"},{\"field\":\"焉\",\"series\":\"30\",\"text\":\"句末语气词，这里指当于现代汉语的“啊” “呀”，助词。\"}],\"series\":\"00\",\"text\":\"　　水陆草木之花，可爱者甚蕃。晋陶渊明独爱菊。" +
                "自李唐来，世人甚爱牡丹。予独爱莲之出淤泥而不染，濯清涟而不妖，中通外直，不蔓不枝，香远益清，亭亭净植，可远观而不可亵玩焉。\",\"translation\":\"　　水上、陆地上各种草本木本的花，值得喜爱的非常多。晋代的陶渊明只喜爱菊花。从李氏唐朝以来，世上的人十分喜爱牡丹。而我唯独喜爱莲花从淤泥中长出却不被污染，经过清水的洗涤却不显得妖艳。它的茎内空外直，不生蔓不长枝，香气远播更加清香，笔直洁净地立在水中。人们只能远远地观赏而不能玩弄它啊。\"},{\"classic\":false,\"comments\":[{\"field\":\"　　谓\",\"series\":\"00\",\"text\":\"认为。\"},{\"field\":\"隐逸者\",\"series\":\"01\",\"text\":\"指隐居的人。\"},{\"field\":\"在封建社会里，有些人不愿意跟统治者同流合污，就隐居避世；君子\",\"series\":\"02\",\"text\":\"指道德品质高尚的人。\"},{\"field\":\"者\",\"series\":\"03\",\"text\":\"……的人或物。\"},{\"field\":\"噫\",\"series\":\"05\",\"text\":\"感叹词，相当于现在的“唉”。\"},{\"field\":\"菊之爱\",\"series\":\"06\",\"text\":\"对于菊花的喜爱。\"},{\"field\":\"之\",\"series\":\"07\",\"text\":\"语气助词，的。\"},{\"field\":\"（一说为“宾语提前的标志”）鲜\"" +
                ",\"series\":\"08\",\"text\":\"少。\"},{\"field\":\"闻\",\"series\":\"09\",\"text\":\"听说。\"},{\"field\":\"同予者何人\",\"series\":\"10\",\"text\":\"像我一样的还有什么人呢？宜乎众矣。\"},{\"field\":\"宜乎\",\"series\":\"11\",\"text\":\"当然（应该）。\"},{\"field\":\"宜\",\"series\":\"12\",\"text\":\"当。\"},{\"field\":\"众\",\"series\":\"13\",\"text\":\"众多。\"}],\"series\":\"01\",\"text\":\"　　予谓菊，花之隐逸者也；牡丹，花之富贵者也；莲，花之君子者也。噫！菊之爱，陶后鲜有闻。莲之爱，同予者何人？牡丹之爱，宜乎众矣。\",\"translation\":\"　　我认为菊花，是花中的隐士；牡丹，是花中的富贵者；莲花，是花中品德高尚的君子。唉！对于菊花的喜爱，陶渊明以后就很少听到了。对于莲花的喜爱，像我一样的还有什么人呢？对于牡丹的喜爱，当然就很多人了！\"}]}";
    }

}