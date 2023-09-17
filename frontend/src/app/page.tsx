import React from 'react';
import Header from './components/Header';
import DownloadForm from './components/DownloadForm';
import styles from './styles/Home.module.css';
import './global.css'

const Home: React.FC = () => {
    return (
        <div className={styles.container}>
            <Header />
            <main>
                <p>This is the main content of the report generator.</p>
                <DownloadForm />
            </main>
        </div>
    );
};

export default Home;
