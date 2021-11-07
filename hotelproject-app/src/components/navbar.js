import React from "react";

import NavbarItem from "./navbaritem";

function Navbar(){
    
    return(
        <div className="navbar navbar-expand-lg fixed-top navbar-dark bg-primary">
            <div className="container">
                <a href="http://bootswatch.com/" className="navbar-brand">Hotel Project</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" is="navbarResponsive">
                    <ul className="navbar-nav">
                        <NavbarItem href="#/home" label="Home" />
                        <NavbarItem href="#/cadastro-usuario" label="Usuario"/>
                        <NavbarItem href="#/login" label="Login"/>
                    </ul>
                </div>
            </div>
        </div>
    )

}