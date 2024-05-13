import React from "react";
import SearchBar from "../SearchBar/SearchBar";
import { IoMdLogIn } from 'react-icons/io';
import './Header.css';
import CartButton from "../CartButton/CartButton";


function Header() {
    return (
        <header className="header">
            <div className="container">

                <SearchBar />
                <CartButton />
                <a
                    className="login"
                    type="button"
                    href="Formulario"
                >Login <IoMdLogIn /></a>
            </div>

        </header>
    )
}

export default Header;