import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const MakePage = () => {
    const [productName, setProductName] = useState('');
    const categoryArray = ['BBQ_CHICKEN', 'KYOCHON_CHICKEN'];
    const [price, setPrice] = useState('');
    const [description, setDescription] = useState('');
    const [category, setCategory] = useState('');
    const onChange1 = (e) => {
        setProductName(e.target.value);
    };

    const onChange2 = (e) => {
        setPrice(e.target.value);
    };

    const onChange3 = (e) => {
        setDescription(e.target.value);
    };

    const submitHandler = (e) => {
        e.preventDefault();
        const price1 = parseInt(price);
        const send_param = {
            productName,
            category,
            price: price1,
            description,
        };

        axios
            .post('http://localhost:8080/api/v1/shop/new', send_param)
            .then((response) => {
                alert('등록 성공');
                // Do something with the response if needed
            })
            .catch((err) => {
                alert('서버 장애');
                console.error(err);
            });
    };

    return (
        <div
            style={{
                marginTop: 70,
                maxWidth: 450,
                marginLeft: 'auto',
                marginRight: 'auto',
                padding: '20px',
                border: '1px solid #ccc',
            }}
        >
            <h2 style={{ textAlign: 'center', color: 'green', fontWeight: 700 }}>치킨 등록하기</h2>
            <Link to="/">주문창</Link>
            <form onSubmit={submitHandler}>
                <div>
                    <label>치킨 이름 : </label>
                    <input label="치킨 이름" type="text" value={productName} setValue={setProductName} onChange={onChange1} />
                </div>
                <div>
                    <label>카테고리 : </label>
                    <select value={category} onChange={(e) => setCategory(e.target.value)}>
                        {categoryArray.map((sport, index) => (
                            <option key={index} value={sport}>
                                {sport}
                            </option>
                        ))}
                    </select>
                </div>
                <div>
                    <label>가격 : </label>
                    <input label="가격" value={price} type="text" onChange={onChange2} />
                </div>
                <div>
                    <label>설명 : </label>
                    <input label="설명" type="text" value={description} onChange={onChange3} />
                </div>
                <>
                    <button
                        type="submit"
                        style={{
                            marginTop: '15px',
                            padding: '10px 20px',
                            backgroundColor: 'green',
                            color: '#fff',
                        }}
                    >
                        등록하기
                    </button>
                </>
            </form>
        </div>
    );
};

export default MakePage;
