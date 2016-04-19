<!-- Static navbar -->
   <nav class="navbar navbar-default navbar-static-top">
     <div class="container">
       <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
           <span class="sr-only">Toggle navigation</span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
           <span class="icon-bar"></span>
         </button>
         <a class="navbar-brand" href="/tilesapp">Spring security</a>
       </div>
       <div id="navbar" class="navbar-collapse collapse">
         <ul class="nav navbar-nav">
           <li class="${current=='index' ? 'active' : ''}"><a href="/tilesapp">Home</a></li>
           <li class="${current=='users' ? 'active' : ''}"><a href="/tilesapp/users">Users</a></li>
         </ul>
         <ul class="nav navbar-nav navbar-right">
           <li><a href="../navbar/">Default</a></li>
           <li class="active"><a href="./">Static top <span class="sr-only">(current)</span></a></li>
           <li><a href="../navbar-fixed-top/">Fixed top</a></li>
         </ul>
       </div><!--/.nav-collapse -->
     </div>
   </nav>
