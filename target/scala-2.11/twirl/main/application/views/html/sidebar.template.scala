
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
object sidebar extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="white-box">
	<h2> Lorem ipsum dolor sit amet </h2>

consectetur adipiscing elit. Pellentesque lobortis blandit est ut ornare. Duis non lectus a neque mollis tempus at eu magna. Morbi orci sapien, venenatis vel sapien ut, laoreet consectetur ligula. Morbi porttitor enim vitae sem scelerisque pellentesque. Suspendisse fringilla auctor ante, ut ultrices arcu feugiat et. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce auctor, ipsum at eleifend sollicitudin, augue metus sagittis mauris, id convallis ante leo in sem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed hendrerit nisi augue. Vivamus blandit urna sit amet nisl tristique dictum.
<br>
	Cras neque elit, accumsan id consectetur nec, fringilla et sem. Donec id rhoncus ante, sit amet tempor ante. Vivamus eget imperdiet ex, eget egestas turpis. Nam ac ultricies mauris, eu ultricies leo. Donec sodales, diam blandit dapibus egestas, sapien nisl faucibus risus, a tincidunt odio velit at leo. Aliquam in interdum urna, vitae auctor libero. Sed in elit non felis laoreet malesuada. Nunc id rhoncus enim. Nullam eu augue enim. Aliquam malesuada vestibulum diam non ultricies. Aliquam aliquet vehicula posuere. Sed accumsan dictum dapibus. Sed id dolor dui. Nunc sollicitudin pulvinar ex, non tincidunt nulla.

	Mauris a dolor eget massa egestas tristique. Pellentesque fermentum, nibh non tincidunt mattis, metus diam dapibus mauris, sit amet dapibus nisl nisi id sem. Etiam odio dolor, aliquet in maximus et, pellentesque at libero. Nunc pretium, metus sed rhoncus efficitur, purus ligula venenatis metus, vel varius dolor quam a turpis. Integer laoreet dui a ullamcorper tempor. Praesent sagittis semper est vitae volutpat. Phasellus a tristique augue. Suspendisse elementum ornare lacus eu fermentum. Morbi aliquam finibus arcu at rutrum. Phasellus rhoncus enim id sapien lobortis vehicula. Mauris pharetra nibh nec lacus elementum euismod. Donec aliquam tincidunt urna porta consectetur. Nullam imperdiet eleifend aliquet. Duis sodales, lorem quis dapibus mattis, urna metus ullamcorper massa, mollis vulputate turpis lorem ac leo.
</div>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/application/views/sidebar.scala.html
                  HASH: e4f2bbd97d5b22fb010d5500c5df5f47d69ee4bb
                  MATRIX: 812->0
                  LINES: 29->1
                  -- GENERATED --
              */
          