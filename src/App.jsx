import React from 'react';
import Header from './components/Header/Header';
import Products from './components/Products/Products';
import Provider from './context/Provider';
import Cart from './components/Cart/Cart';


function App({ children }) {

  return (
    <Provider >
      <Header />
      <Products />
      <Cart />
    </Provider>
  );
}

export default App
