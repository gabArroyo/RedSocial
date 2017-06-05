<%@ page contentType="text/html;charset=UTF-8" language="java" import="models.BeanSessionUser" %>

<section class="section">
<div class="card">
	<div class="card-content">
		<div class="media">
			<div class="media-left">
				<figure class="image is-64x64">
					<img src="http://bulma.io/images/placeholders/96x96.png" alt="Image">
				</figure>
			</div>
			<div class="media-content">
				<p class="title is-4"><%= ((BeanSessionUser)session.getAttribute("user")).getUsername() %></p>
				<p class="subtitle is-6">@<%= ((BeanSessionUser)session.getAttribute("user")).getCurrentPage() %></p>
			</div>
		</div>
		<div class="content">
			Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			Phasellus nec iaculis mauris.Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			Phasellus nec iaculis mauris.Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			Phasellus nec iaculis mauris.
			<a>@bulmaio</a>. <a>#css</a> <a>#responsive</a>
			<br>
			<small>11:09 PM - 1 Jan 2016</small>
		</div>
	</div>
	</div>
</section>