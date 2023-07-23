import '../App.css';
import 'bootstrap/dist/css/bootstrap.css';
import React, { useEffect, useState } from 'react';
import { ProductList } from '../components/ProductList';
import { Summary } from '../components/Summary';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';

const OrderPage = () => {
    const [products, setProducts] = useState([{ productId: 'uuid-1', productName: '황금 올리브 1', category: 'BBQ_CHICKEN', price: 23000 }]);
    const [items, setItems] = useState([]);
    const navigate = useNavigate();

    const handleAddClicked = (productId) => {
        const product = products.find((v) => v.productId === productId);
        const found = items.find((v) => v.productId === productId);
        const updatedItems = found
            ? items.map((v) => (v.productId === productId ? { ...v, count: v.count + 1 } : v))
            : [
                  ...items,
                  {
                      ...product,
                      count: 1,
                  },
              ];
        setItems(updatedItems);
    };

    const handleButtonClick = () => {
        navigate('/');
    };

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/shop/products').then((v) => setProducts(v.data));
    }, []);

    const handleOrderSubmit = (order) => {
        if (items.length === 0) {
            alert('아이템을 추가해 주세요!');
        } else {
            axios
                .post('http://localhost:8080/api/v1/shop/orders/new', {
                    orderItems: items.map((v) => ({
                        productId: v.productId,
                        category: v.category,
                        price: v.price,
                        quantity: v.count,
                    })),
                })
                .then(
                    (v) => {
                        alert('주문이 정상적으로 접수되었습니다.');
                        // history.push('/');
                    },
                    (e) => {
                        alert('서버 장애');
                        console.error(e);
                    }
                );
        }
    };

    return (
        <div className="container-fluid">
            <div className="row justify-content-center m-4">
                <h1 className="text-center">주문 하기</h1>
                <Link to="/make">등록 화면으로 이동</Link>
            </div>
            <div className="card">
                <div className="row">
                    <div className="col-md-8 mt-4 d-flex flex-column align-items-start p-3 pt-0">
                        <ProductList products={products} onAddClick={handleAddClicked} />
                    </div>
                    <div className="col-md-4 summary p-4">
                        <Summary items={items} onOrderSubmit={handleOrderSubmit} onAddClick={handleButtonClick} />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default OrderPage;
