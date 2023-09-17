import React from 'react';
import Header from '../components/Header';
import styles from '../../styles/Home.module.css'

const Home: React.FC = () => {
    return (
        <div className={styles.container}>
            <Header />
            <main>
                <p>This is the main content of the report generator.</p>
            </main>
        </div>
    );
};

export default Home;