
package gallery.views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object galleryFramework extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Boolean,Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(shouldSize: Boolean, biggestThumb: Int = 400):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*2.1*/("""<script src='assets/javascripts/packery.pkgd.min.js'></script>

<style>
    .gallery """),format.raw/*5.14*/("""{"""),format.raw/*5.15*/("""
        """),format.raw/*6.9*/("""padding: 0;
        margin: 0;
        width: 1200px;
    """),format.raw/*9.5*/("""}"""),format.raw/*9.6*/("""

    """),format.raw/*11.5*/(""".gallery .imageWrapper """),format.raw/*11.28*/("""{"""),format.raw/*11.29*/("""
        """),format.raw/*12.9*/("""padding: 10px;
        margin: 0;
        /*object-fit: contain;*/
        transition: padding 0.2s ease;
    """),format.raw/*16.5*/("""}"""),format.raw/*16.6*/("""

    """),format.raw/*18.5*/(""".gallery .imageWrapper .loader """),format.raw/*18.36*/("""{"""),format.raw/*18.37*/("""
        """),format.raw/*19.9*/("""background: url(assets/images/ajax-loader.gif) #CCC no-repeat center;
        box-shadow: 0 0 0 0 rgba(0, 0, 0, 0.5);
        /*box-shadow: inset 0 0 40px 0 rgba(0, 0, 0, 0.5);*/
        height: 100%;
        width: 100%;
        border-radius: 5px;
        transition: box-shadow 0.2s ease;
    """),format.raw/*26.5*/("""}"""),format.raw/*26.6*/("""

    """),format.raw/*28.5*/(""".gallery .imageWrapper .loader .image """),format.raw/*28.43*/("""{"""),format.raw/*28.44*/("""
        """),format.raw/*29.9*/("""border-radius: 5px;
        opacity: 0;
        transition: opacity 1s ease;
    """),format.raw/*32.5*/("""}"""),format.raw/*32.6*/("""

    """),format.raw/*34.5*/("""#viewerUnderlay """),format.raw/*34.21*/("""{"""),format.raw/*34.22*/("""
        """),format.raw/*35.9*/("""opacity: 0;
        position: fixed;
        z-index: -3;
        top: 0;
        left: 0;
        height: 100%;
        width: 100%;
        background-color: rgba(0, 0, 0, 0.9);
        transition: opacity 0.2s linear;
    """),format.raw/*44.5*/("""}"""),format.raw/*44.6*/("""

    """),format.raw/*46.5*/("""#viewerOverlay """),format.raw/*46.20*/("""{"""),format.raw/*46.21*/("""
        """),format.raw/*47.9*/("""opacity: 0;
        position: fixed;
        z-index: -1;
        top: 50%;
        left: 50%;
        height: 0;
        width: 0;
        background: url(assets/images/ajax-loader.gif) #CCC no-repeat center;
        /*background-size: cover;*/
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.5);
        transition: opacity 0.2s ease,
                    height 0.2s ease,
                    width 0.2s ease,
                    top 0.2s ease,
                    left 0.2s ease;
    """),format.raw/*62.5*/("""}"""),format.raw/*62.6*/("""

    """),format.raw/*64.5*/("""#viewerOverlay #viewerImage """),format.raw/*64.33*/("""{"""),format.raw/*64.34*/("""
        """),format.raw/*65.9*/("""opacity: 0;
        transition: opacity 0.2s ease;
    """),format.raw/*67.5*/("""}"""),format.raw/*67.6*/("""

    """),format.raw/*69.5*/(""".gallery .imageWrapper:hover """),format.raw/*69.34*/("""{"""),format.raw/*69.35*/("""
        """),format.raw/*70.9*/("""padding: 0px;
    """),format.raw/*71.5*/("""}"""),format.raw/*71.6*/("""

    """),format.raw/*73.5*/(""".gallery .imageWrapper:hover .loader """),format.raw/*73.42*/("""{"""),format.raw/*73.43*/("""
        """),format.raw/*74.9*/("""box-shadow: 0 15px 15px -10px rgba(0, 0, 0, 0.5);
    """),format.raw/*75.5*/("""}"""),format.raw/*75.6*/("""
"""),format.raw/*76.1*/("""</style>

<script>
    var $galleries = $('.gallery');
    var precentBig = 0.1;
    var precentMedium = 0.3;
    var sizingLimit = 4;
    var biggestSize = """),_display_(/*83.24*/biggestThumb),format.raw/*83.36*/(""";

    for (var i = 0; i < $galleries.length; i++) """),format.raw/*85.49*/("""{"""),format.raw/*85.50*/("""
        """),format.raw/*86.9*/("""var $tempThumbs = $($galleries[i]).children('.imageWrapper');

        $tempThumbs.append('<div class="loader"></div>');

        // Uncomment this and make Gallery.java sort by date?
        $tempThumbs.sort(function(a, b) """),format.raw/*91.41*/("""{"""),format.raw/*91.42*/("""
            """),format.raw/*92.13*/("""return $(b).data("score") - $(a).data("score");
        """),format.raw/*93.9*/("""}"""),format.raw/*93.10*/(""");

        var imagesTotal = $tempThumbs.length;
        var imagesBig = Math.ceil(imagesTotal*precentBig);
        var imagesMedium = Math.ceil(imagesTotal*precentMedium);
        var scores = $tempThumbs.data('score');
        for (var j = 0; j < $tempThumbs.length; j++) """),format.raw/*99.54*/("""{"""),format.raw/*99.55*/("""
            """),format.raw/*100.13*/("""var size = biggestSize;
            if (imagesTotal >= sizingLimit && """),_display_(/*101.48*/shouldSize),format.raw/*101.58*/(""") """),format.raw/*101.60*/("""{"""),format.raw/*101.61*/("""
                """),format.raw/*102.17*/("""if (imagesBig > 0) """),format.raw/*102.36*/("""{"""),format.raw/*102.37*/("""
                    """),format.raw/*103.21*/("""imagesBig--;
                """),format.raw/*104.17*/("""}"""),format.raw/*104.18*/(""" """),format.raw/*104.19*/("""else if (imagesMedium > 0) """),format.raw/*104.46*/("""{"""),format.raw/*104.47*/("""
                    """),format.raw/*105.21*/("""imagesMedium--;
                    size = biggestSize / 2;
                """),format.raw/*107.17*/("""}"""),format.raw/*107.18*/(""" """),format.raw/*107.19*/("""else """),format.raw/*107.24*/("""{"""),format.raw/*107.25*/("""
                    """),format.raw/*108.21*/("""size = biggestSize / 4;
                """),format.raw/*109.17*/("""}"""),format.raw/*109.18*/("""
            """),format.raw/*110.13*/("""}"""),format.raw/*110.14*/("""
            """),format.raw/*111.13*/("""var $tempThumb = $($tempThumbs[j]);
            $tempThumb.css('height', size);
            $tempThumb.css('width', size);
        """),format.raw/*114.9*/("""}"""),format.raw/*114.10*/("""
    """),format.raw/*115.5*/("""}"""),format.raw/*115.6*/("""

    """),format.raw/*117.5*/("""var $grids = $galleries.packery("""),format.raw/*117.37*/("""{"""),format.raw/*117.38*/("""
        """),format.raw/*118.9*/("""// options
        itemSelector: '.imageWrapper',
        //columnWidth: 100
    """),format.raw/*121.5*/("""}"""),format.raw/*121.6*/(""");

    $("body")
        .append('<div id="viewerUnderlay"></div>')
        .append('<div id="viewerOverlay">');

    var $underlay = $('#viewerUnderlay');
    var $overlay = $('#viewerOverlay');
    var $thumbs = $galleries.children('.imageWrapper');
    var $window = $(window);
    var border = 30;

    $underlay.click(function() """),format.raw/*133.32*/("""{"""),format.raw/*133.33*/("""
        """),format.raw/*134.9*/("""$underlay.on('transitionend webkitTransitionEnd oTransitionEnd otransitionend MSTransitionEnd', function() """),format.raw/*134.116*/("""{"""),format.raw/*134.117*/("""
            """),format.raw/*135.13*/("""$underlay.css('z-index', -2);
            $overlay.css('z-index', -1);
            $overlay.css('background-image', '');
            $overlay.empty();
        """),format.raw/*139.9*/("""}"""),format.raw/*139.10*/(""");
        $underlay.css('opacity', 0);
        $overlay.css('opacity', 0);
        $overlay.css('height', 0);
        $overlay.css('width', 0);
        $overlay.css('top', '50%');
        $overlay.css('left', '50%');
    """),format.raw/*146.5*/("""}"""),format.raw/*146.6*/(""");

    $('.gallery .imageWrapper').click(function() """),format.raw/*148.50*/("""{"""),format.raw/*148.51*/("""
        """),format.raw/*149.9*/("""$underlay.off('transitionend webkitTransitionEnd oTransitionEnd otransitionend MSTransitionEnd');
        var $image = $(this);
        var allowedWidth = $window.width() - 2*border;
        var allowedHeight = $window.height() - 2*border;

        var imgWidth = $image.data("orgwidth");
        var imgHeight = $image.data("orgheight");
        if (imgHeight > allowedHeight || imgWidth > allowedWidth) """),format.raw/*156.67*/("""{"""),format.raw/*156.68*/("""
            """),format.raw/*157.13*/("""var aspect = imgHeight / imgWidth;
            var heightOver = imgHeight - allowedHeight;
            var widthOver = imgWidth - allowedWidth;
            if (heightOver > widthOver) """),format.raw/*160.41*/("""{"""),format.raw/*160.42*/("""
                """),format.raw/*161.17*/("""imgHeight = allowedHeight;
                imgWidth = imgHeight / aspect;
            """),format.raw/*163.13*/("""}"""),format.raw/*163.14*/(""" """),format.raw/*163.15*/("""else """),format.raw/*163.20*/("""{"""),format.raw/*163.21*/("""
                """),format.raw/*164.17*/("""imgWidth = allowedWidth;
                imgHeight = imgWidth * aspect;
            """),format.raw/*166.13*/("""}"""),format.raw/*166.14*/("""
        """),format.raw/*167.9*/("""}"""),format.raw/*167.10*/("""

        """),format.raw/*169.9*/("""var imgLeft = ($window.width() - imgWidth)/2;
        var imgTop = ($window.height() - imgHeight)/2;

        $overlay.css("width", imgWidth);
        $overlay.css("height", imgHeight);
        $overlay.css("left", imgLeft);
        $overlay.css("top", imgTop);
        $underlay.css('opacity', 1);
        $underlay.css('z-index', 99999);
        $overlay.css('opacity', 1);
        $overlay.css('z-index', 100000);

        // Load image
        var tempImg = new Image();

        tempImg.onload = function() """),format.raw/*184.37*/("""{"""),format.raw/*184.38*/("""
            """),format.raw/*185.13*/("""this.style.opacity = 1;
        """),format.raw/*186.9*/("""}"""),format.raw/*186.10*/("""

        """),format.raw/*188.9*/("""tempImg.id = "viewerImage";
        tempImg.src = $image.data("orgurl");
        $overlay.append(tempImg);

        // Give score
        $.get("/api/clickScoreImage", """),format.raw/*193.39*/("""{"""),format.raw/*193.40*/("""imageId: $image.data("id")"""),format.raw/*193.66*/("""}"""),format.raw/*193.67*/(""");
    """),format.raw/*194.5*/("""}"""),format.raw/*194.6*/(""");

    window.onload = function() """),format.raw/*196.32*/("""{"""),format.raw/*196.33*/("""
        """),format.raw/*197.9*/("""for (var i = 0; i < $thumbs.length; i++) """),format.raw/*197.50*/("""{"""),format.raw/*197.51*/("""
            """),format.raw/*198.13*/("""var $thumb = $($thumbs[i]);
            var tempImg = new Image();

            tempImg.onload = function() """),format.raw/*201.41*/("""{"""),format.raw/*201.42*/("""
                """),format.raw/*202.17*/("""this.style.opacity = 1;
            """),format.raw/*203.13*/("""}"""),format.raw/*203.14*/("""

            """),format.raw/*205.13*/("""tempImg.className = "image";
            tempImg.src = $thumb.data("thumburl");
            $thumb.children().first().prepend(tempImg);
        """),format.raw/*208.9*/("""}"""),format.raw/*208.10*/("""
    """),format.raw/*209.5*/("""}"""),format.raw/*209.6*/("""
"""),format.raw/*210.1*/("""</script>"""))}
  }

  def render(shouldSize:Boolean,biggestThumb:Int): play.twirl.api.HtmlFormat.Appendable = apply(shouldSize,biggestThumb)

  def f:((Boolean,Int) => play.twirl.api.HtmlFormat.Appendable) = (shouldSize,biggestThumb) => apply(shouldSize,biggestThumb)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/gallery/views/galleryFramework.scala.html
                  HASH: bb922e4f8a89d2e8e3c770bce66532f0040faf25
                  MATRIX: 747->1|881->47|909->49|1024->137|1052->138|1088->148|1175->209|1202->210|1237->218|1288->241|1317->242|1354->252|1495->366|1523->367|1558->375|1617->406|1646->407|1683->417|2013->720|2041->721|2076->729|2142->767|2171->768|2208->778|2319->862|2347->863|2382->871|2426->887|2455->888|2492->898|2753->1132|2781->1133|2816->1141|2859->1156|2888->1157|2925->1167|3454->1669|3482->1670|3517->1678|3573->1706|3602->1707|3639->1717|3723->1774|3751->1775|3786->1783|3843->1812|3872->1813|3909->1823|3955->1842|3983->1843|4018->1851|4083->1888|4112->1889|4149->1899|4231->1954|4259->1955|4288->1957|4480->2122|4513->2134|4594->2187|4623->2188|4660->2198|4917->2427|4946->2428|4988->2442|5072->2499|5101->2500|5410->2781|5439->2782|5482->2796|5582->2868|5614->2878|5645->2880|5675->2881|5722->2899|5770->2918|5800->2919|5851->2941|5910->2971|5940->2972|5970->2973|6026->3000|6056->3001|6107->3023|6214->3101|6244->3102|6274->3103|6308->3108|6338->3109|6389->3131|6459->3172|6489->3173|6532->3187|6562->3188|6605->3202|6767->3336|6797->3337|6831->3343|6860->3344|6896->3352|6957->3384|6987->3385|7025->3395|7137->3479|7166->3480|7542->3827|7572->3828|7610->3838|7747->3945|7778->3946|7821->3960|8012->4123|8042->4124|8299->4353|8328->4354|8412->4409|8442->4410|8480->4420|8921->4832|8951->4833|8994->4847|9210->5034|9240->5035|9287->5053|9404->5141|9434->5142|9464->5143|9498->5148|9528->5149|9575->5167|9690->5253|9720->5254|9758->5264|9788->5265|9828->5277|10384->5804|10414->5805|10457->5819|10518->5852|10548->5853|10588->5865|10790->6038|10820->6039|10875->6065|10905->6066|10941->6074|10970->6075|11036->6112|11066->6113|11104->6123|11174->6164|11204->6165|11247->6179|11387->6290|11417->6291|11464->6309|11530->6346|11560->6347|11605->6363|11780->6510|11810->6511|11844->6517|11873->6518|11903->6520
                  LINES: 26->1|29->1|30->2|33->5|33->5|34->6|37->9|37->9|39->11|39->11|39->11|40->12|44->16|44->16|46->18|46->18|46->18|47->19|54->26|54->26|56->28|56->28|56->28|57->29|60->32|60->32|62->34|62->34|62->34|63->35|72->44|72->44|74->46|74->46|74->46|75->47|90->62|90->62|92->64|92->64|92->64|93->65|95->67|95->67|97->69|97->69|97->69|98->70|99->71|99->71|101->73|101->73|101->73|102->74|103->75|103->75|104->76|111->83|111->83|113->85|113->85|114->86|119->91|119->91|120->92|121->93|121->93|127->99|127->99|128->100|129->101|129->101|129->101|129->101|130->102|130->102|130->102|131->103|132->104|132->104|132->104|132->104|132->104|133->105|135->107|135->107|135->107|135->107|135->107|136->108|137->109|137->109|138->110|138->110|139->111|142->114|142->114|143->115|143->115|145->117|145->117|145->117|146->118|149->121|149->121|161->133|161->133|162->134|162->134|162->134|163->135|167->139|167->139|174->146|174->146|176->148|176->148|177->149|184->156|184->156|185->157|188->160|188->160|189->161|191->163|191->163|191->163|191->163|191->163|192->164|194->166|194->166|195->167|195->167|197->169|212->184|212->184|213->185|214->186|214->186|216->188|221->193|221->193|221->193|221->193|222->194|222->194|224->196|224->196|225->197|225->197|225->197|226->198|229->201|229->201|230->202|231->203|231->203|233->205|236->208|236->208|237->209|237->209|238->210
                  -- GENERATED --
              */
          