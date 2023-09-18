'use client';
import React, { useState } from 'react';

const DownloadForm: React.FC = () => {
  const [format, setFormat] = useState('');  // html or text
  const [title, setTitle] = useState('');
  const [subTitle, setSubTitle] = useState('');
  const [content, setContent] = useState('');
  const [footer, setFooter] = useState('');

  const handleDownload = async () => {
    if (!format) return;

    const API_ENDPOINT = process.env.NEXT_PUBLIC_API_ENDPOINT || 'http://localhost:8080';
    const endpoint = `${API_ENDPOINT}/download/report/${format}`;
    try {
      const response = await fetch(endpoint, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ title, subTitle, content, footer }),
      });

      if (response.ok) {
        const blob = await response.blob();
        const link = document.createElement('a');
        link.href = URL.createObjectURL(blob);
        link.download = `report.${format}`;
        link.click();
      } else {
        console.error('Report generation failed.');
      }
    } catch (error) {
      console.error('Error fetching the report:', error);
    }
  };

  return (
    <div>
      <h2>Download Report</h2>
      <div>
        <label>Title: </label>
        <input
          type="text"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
      </div>
      <div>
        <label>SubTitle: </label>
        <input
          type="text"
          value={subTitle}
          onChange={(e) => setSubTitle(e.target.value)}
        />
      </div>
      <div>
        <label>Content: </label>
        <textarea
          value={content}
          onChange={(e) => setContent(e.target.value)}
        />
      </div>
      <div>
        <label>Footer: </label>
        <input
          type="text"
          value={footer}
          onChange={(e) => setFooter(e.target.value)}
        />
      </div>
      <div>
        <label>Format: </label>
        <select value={format} onChange={(e) => setFormat(e.target.value)}>
          <option value="" disabled>Select format</option>
          <option value="html">HTML</option>
          <option value="text">Text</option>
        </select>
      </div>
      <button onClick={handleDownload} disabled={!format}>
        Generate Report
      </button>
    </div>
  );
};

export default DownloadForm;
