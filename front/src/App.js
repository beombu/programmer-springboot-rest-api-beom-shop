import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import { Routes, Route } from 'react-router-dom';
import OrderPage from './page/OrderPage';
import MakePage from './page/MakePage';

function App() {
    return (
        <>
            <Routes>
                <Route path="/" element={<OrderPage />} />
                <Route path="/make" element={<MakePage />} />
            </Routes>
        </>
    );
}

export default App;
