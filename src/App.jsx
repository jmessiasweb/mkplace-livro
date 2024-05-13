import React from 'react';
import Header from './components/Header/Header';
import Products from './components/Products/Products';
import Provider from './context/Provider';
import Cart from './components/Cart/Cart';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Formulario from './components/Formulario/Formulario';


function App({ children }) {

  return (
    <>
    {/* <Provider >
      <Header />
     
    </Provider>
    <Provider >
    <Products />
     
    </Provider> */}
    <BrowserRouter>
            <Routes>
                <Route path="/" exact element={<Provider > <Header /><Products /> <Cart /></Provider>}/>
                <Route path="/Formulario" element={<Formulario/>}/>
            </Routes>
        </BrowserRouter>
    </>
    //  <Products />
    //  <Cart />
  );
}

export default App
