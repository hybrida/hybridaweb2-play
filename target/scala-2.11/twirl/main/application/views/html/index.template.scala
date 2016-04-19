
package application.views.html

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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(newsfeed: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.18*/("""
"""),format.raw/*2.1*/("""<div data-ride="carousel" class="carousel slide" id="carousel-frontpage" data-interval="10000">
	<ol class="carousel-indicators">
		<li class="active" data-slide-to="0" data-target="#carousel-frontpage"></li>
		<li data-slide-to="1" data-target="#carousel-frontpage"></li>
		<li data-slide-to="2" data-target="#carousel-frontpage"></li>
	</ol>
	<div style="padding-top: 37%"></div>
	<div role="listbox" class="carousel-inner container-with-set-aspect-ratio">
		<div class="item active">
			<img src="/assets/images/hybirda.png" data-holder-rendered="true">
		</div>
		<div class="item">
			<img src="/assets/images/Kiltkast.png" data-holder-rendered="true">
		</div>
		<div class="item">
			<img src="/assets/images/instacarousel.png" data-holder-rendered="true">
		</div>
	</div>
	<a data-slide="prev" role="button" href="#carousel-frontpage" class="left carousel-control">
		<span aria-hidden="true" class="glyphicon glyphicon-chevron-left"></span>
		<span class="sr-only">Previous</span>
	</a>
	<a data-slide="next" role="button" href="#carousel-frontpage" class="right carousel-control">
		<span aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span>
		<span class="sr-only">Next</span>
	</a>
</div>
<div class="fp_white" style="margin-top: -.2%">
</div>
<div class="container-fluid center-container">
    <div class="row">
        <div class="col-xs-12 space-above">
            <div class="col-xs-12 drop-shadow">
                <div class="row container-height inverted">
                    <div class="col-sm-6 white-box no-shadow inverted" style="background:#005675;">
											Velkommen til linjeforening Hybrida sin nettside
                    </div>
                    <div class="col-sm-6 white-box no-shadow inverted">
                        <a href=""""),_display_(/*40.35*/staticpages/*40.46*/.routes.About.newStudent()),format.raw/*40.72*/(""""> Ny student? Klikk her!</a>
                    </div>
                    <!--- <div class="col-sm-4 white-box no-shadow inverted" style="background:#7c3f63;">

                    </div> -->
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<a name="nyhetsfeed" style="position:relative; height: 1px; margin-top: -1px; top: -18px; display:block; ">&nbsp;</a>
"""),_display_(/*52.2*/newsfeed),format.raw/*52.10*/("""
"""))}
  }

  def render(newsfeed:Html): play.twirl.api.HtmlFormat.Appendable = apply(newsfeed)

  def f:((Html) => play.twirl.api.HtmlFormat.Appendable) = (newsfeed) => apply(newsfeed)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/application/views/index.scala.html
                  HASH: 353e385f2bbc8c3c0365af1f3923257500231706
                  MATRIX: 733->1|837->17|865->19|2717->1844|2737->1855|2784->1881|3252->2323|3281->2331
                  LINES: 26->1|29->1|30->2|68->40|68->40|68->40|80->52|80->52
                  -- GENERATED --
              */
          